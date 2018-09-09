package service;

import java.util.List;

import com.imooc.entity.Seckill;

import dto.Exposer;
import dto.SeckillExecution;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import exception.SeckillException;


public interface SeckillService {

	/**
	 * 查询所有秒杀记录
	 * 
	 */
	List<Seckill> getSeckillList();

	/**
	 * 查询单个记录
	 * 
	 */

	Seckill getById(long seckillId);

	/**
	 * 当秒杀开启时暴露秒杀接口，否则显示当前系统时间
	 * 
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);

	/**
	 * 秒杀执行结束，有可能秒杀成功，要抛出所允许的异常
	 * 
	 * @param seckillId
	 * @param uesrphone
	 * @param md5
	 * @return
	 */
	SeckillExecution executeSeckill(long seckillId, long uesrphone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException;
	
	/**
	 * 执行秒杀操作by 存储过程
	 */
	SeckillExecution executeSeckillProcedure(long seckillId, long uesrphone, String md5);
			
}
