package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.dao.SuccessKilledDao;
import com.imooc.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessSeckillDao {
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void insertSuccessKilled(){
		long seckillId=1000L;
        long userPhone=13476191877L;
		int insertCount=successKilledDao.insertSuccessKilled(seckillId,userPhone);
		System.out.println(insertCount);
		
		
	}
	@Test
	public void queryWithSeckill(){
		long seckillId=1000L;
        long userPhone=13476191877L;
		
        SuccessKilled successKilled=   successKilledDao.queryWithSeckill(seckillId, userPhone);
        System.out.println(successKilled);
		
	}

}
