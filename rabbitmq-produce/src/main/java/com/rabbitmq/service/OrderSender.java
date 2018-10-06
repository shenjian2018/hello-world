package com.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.Constant.Constants;
import com.rabbitmq.dao.BrokerMessageLogDao;
import com.rabbitmq.model.BrokerMessageLogPO;
import com.rabbitmq.model.OrderPO;

/**
 * <p>
 * Title: OrderSender
 * </p>
 * <p>
 * Description:发送消息
 * </p>
 * @author shenjian
 * @date 2018年9月24日
 */
@Component
public class OrderSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private BrokerMessageLogDao brokerMessageLogDao;

	private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			String messageId = correlationData.getId();
			if (ack) {
				// 如果confirm返回成功，则进行更新
				BrokerMessageLogPO messageLogPO = new BrokerMessageLogPO();
				messageLogPO.setMessageId(messageId);
				messageLogPO.setStatus(Constants.OrderSendStatus.SEND_SUCCESS);
				brokerMessageLogDao.changeBrokerMessageLogStatus(messageLogPO);
			} else {
				System.out.println("异常处理...");
			}

		}

	};

	public void send(OrderPO orderPO) {
		// 设置回调方法
		rabbitTemplate.setConfirmCallback(confirmCallback);
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(orderPO.getMessageId());
		// 发送消息
		rabbitTemplate.convertAndSend("order-exchange", "order.abcd", orderPO, correlationData);
	}
}
