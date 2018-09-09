package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.entity.Seckill;

import dto.Exposer;
import dto.SeckillExecution;
import exception.SeckillException;
import service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;

	@Test
	public void testgetSeckillList() {
		List<Seckill> seckill = seckillService.getSeckillList();
		System.out.println(seckill);
	}

	@Test
	public void TestgetById() {
		long seckillId = 1000;
		Seckill seckill = seckillService.getById(seckillId);
		System.out.println(seckill);
	}

	public void testLogin() {
		long seckillId = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if (exposer.isExposer()) {
			System.out.println(exposer);
			long uesrphone = 12345678910L;
			String md5 = exposer.getMd5();
			try {

				SeckillExecution seckillExecution = seckillService
						.executeSeckill(seckillId, uesrphone, md5);
				System.out.println(seckillExecution);
			} catch (SeckillException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(exposer);
		}

	}

}
