package com.learn;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.Application;
import com.rabbitmq.model.OrderPO;
import com.rabbitmq.service.OrderSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ApplicationTests {

	@Autowired
	private OrderSender orderSender;

	@Test
	public void contextLoads() {
	}
    
	
	@Test
	public void sendTest1() {
		OrderPO orderPO = new OrderPO();
		orderPO.setId("201809242039");
		orderPO.setName("测试订单");
		orderPO.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		orderSender.send(orderPO);
	}
}
