package com.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.model.OrderPO;
/**
 * 

* <p>Title: OrderSender</p>  

* <p>Description:发送消息 </p>  

* @author shenjian
* @date 2018年9月24日
 */
@Component
public class OrderSender {
	
	@Autowired
	private RabbitTemplate  rabbitTemplate;
	
	 private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			String messageId = correlationData.getId();
			if(ack) {
				
			}else {
				System.out.println("异常处理...");	
			}
			
		}
	      
	    };
	
	public void send(OrderPO  orderPO) {
		rabbitTemplate.setConfirmCallback(confirmCallback);
		   CorrelationData correlationData = new CorrelationData();
		   correlationData.setId(orderPO.getMessageId());
		rabbitTemplate.convertAndSend("order-exchange", "order.abcd", orderPO, correlationData);
	}
}
