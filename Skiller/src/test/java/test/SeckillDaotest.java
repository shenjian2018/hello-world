package test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.dao.SeckillDao;
import com.imooc.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaotest {
	@Resource
	private SeckillDao seckillDao;

	@Test
	public void queryById() throws Exception {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill);
	}

	@Test
	public void queryAll() {
		List<Seckill> seckills = seckillDao.queryAll(0, 4);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}

	}
	
	@Test
	public void reduceNumber() {
		Date date=new Date();
		int  updatecount=seckillDao.reduceNumber(1000L, date);
		System.out.println(updatecount);
		

	}
}
