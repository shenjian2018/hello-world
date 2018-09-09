package service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.imooc.dao.SeckillDao;
import com.imooc.dao.SuccessKilledDao;
import com.imooc.dao.cache.RedisDao;
import com.imooc.entity.Seckill;
import com.imooc.entity.SuccessKilled;

import dto.Exposer;
import dto.SeckillExecution;
import enums.SeckillState;
import exception.SeckillCloseException;
import exception.SeckillException;
import exception.RepeatKillException;
import service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService {
	private final String salt = "seses5fdfasasd";

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	@Autowired
	private RedisDao redisDao;

	public List<Seckill> getSeckillList() {
		List<Seckill> list = seckillDao.queryAll(0, 4);
		return list;
	}

	public Seckill getById(long seckillId) {

		return seckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		// 缓存优化，从缓存中取
		Seckill seckill = redisDao.getSeckill(seckillId);
		if (seckill == null) {
			// 去数据库中取
			seckill = seckillDao.queryById(seckillId);
			if (seckill != null) {

				redisDao.putSeckill(seckill);
			} else {
				return new Exposer(false, seckillId);
			}

		}

		Date date = new Date();
		Date start = seckill.getStartTime();
		Date end = seckill.getEndTime();
		if (date.getTime() < start.getTime() || date.getTime() > end.getTime()) {
			return new Exposer(false, seckillId, date.getTime(),
					start.getTime(), end.getTime());
		}
		String md5 = getMd5(seckillId);
		return new Exposer(true, seckillId, md5);
	}

	private String getMd5(long seckillId) {
		String base = seckillId + "/" + salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long uesrphone,
			String md5) throws SeckillException, RepeatKillException,
			SeckillCloseException {
		if (md5 == null || !md5.equals(getMd5(seckillId))) {

			throw new SeckillException("Seckill date Rewire");
		}

		Date now = new Date();
		// 减库存
		try {
			// 插入购买明细
			int successKill = successKilledDao.insertSuccessKilled(seckillId,
					uesrphone);
			if (successKill < 0) {
				throw new RepeatKillException("seckill  Repeat ");

			} else {
				// 减库存
				int number = seckillDao.reduceNumber(seckillId, now);
				if (number <= 0) {
					throw new SeckillCloseException("seckill Close");
				} else {
					// 秒杀成功

					SuccessKilled successKilled = successKilledDao
							.queryWithSeckill(seckillId, uesrphone);
					return new SeckillExecution(seckillId,
							SeckillState.SUCCESS, successKilled);

				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch (RepeatKillException e2) {
			throw e2;
		} catch (SeckillException e) {
			logger.error(e.getMessage(), e);
			throw new SeckillException("inner error :" + e.getMessage());
		}

	}

	@Override
	public SeckillExecution executeSeckillProcedure(long seckillId,
			long uesrphone, String md5) {
		if (md5 == null || md5.equals(getMd5(seckillId))) {
			return new SeckillExecution(seckillId, SeckillState.DATE_REWRITE);
		}
		Date killTime = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seckillId", seckillId);
		map.put("uesrphone", uesrphone);
		map.put("killTime", killTime);
		map.put("result", null);
		// 执行存储过程
		try {
			seckillDao.killByProcedure(map);
			int result = MapUtils.getInteger(map, "result", -2);
			if (result == 1) {
				SuccessKilled successKilled = successKilledDao
						.queryWithSeckill(seckillId, uesrphone);
				return new SeckillExecution(seckillId,
						SeckillState.stateinfo(result), successKilled);
			} else {
				return new SeckillExecution(seckillId,
						SeckillState.stateinfo(result));
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return new SeckillExecution(seckillId, SeckillState.INNER_ERROR);
		}

	}

}
