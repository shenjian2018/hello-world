package com.rabbitmq.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.model.OrderPO;

/**
 * 
 * 
 * <p>
 * Title: OrderReceiver
 * </p>
 * 
 * <p>
 * Description:消息接收
 * </p>
 * 
 * @author shenjian
 * @date 2018年9月24日
 */
@Component
public class OrderReceiver {
	@RabbitHandler
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "order-exchange", type = "topic"),
	       value = @Queue(value = "order-queue", durable = "true"),
	       key="order.*"
		))
	public void getMessageId(@Payload OrderPO orderPO, Channel channel, @Headers Map<String, Object> heads) {
		System.out.println("开始消费消息了！！！！！！！！！！！！！！！");
		System.out.println("消息ID是：" + orderPO.getMessageId());
		Long tag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
		try {
			channel.basicAck(tag, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
