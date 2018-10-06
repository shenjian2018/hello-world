package com.rabbitmq.service;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.Constant.Constants;
import com.rabbitmq.dao.BrokerMessageLogDao;
import com.rabbitmq.dao.OrderDao;
import com.rabbitmq.model.BrokerMessageLogPO;
import com.rabbitmq.model.OrderPO;
import com.rabbitmq.util.FastJsonConvertUtils;
/**
 * <p>Title: OrderService</p>  
 * <p>Description: </p>  
 * @author shenjian
 * @date 2018年10月6日
 */
@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private BrokerMessageLogDao brokerMessageLogDao;
	@Autowired
	private OrderSender orderSender;

	/**
	 * 创建订单
	 *
	 * @param order
	 *            订单
	 */
	public void create(OrderPO order) {
		// 当前时间
		Date orderTime = new Date();
		// 业务数据入库
		this.orderDao.insert(order);
		// 消息日志入库
		BrokerMessageLogPO messageLogPO = new BrokerMessageLogPO();
		messageLogPO.setMessageId(order.getMessageId());
		messageLogPO.setMessage(FastJsonConvertUtils.convertObjectToJson(order));
		messageLogPO.setTryCount(0);
		messageLogPO.setStatus(Constants.OrderSendStatus.SENDING);
		messageLogPO.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
		this.brokerMessageLogDao.insert(messageLogPO);
		// 发送消息
		this.orderSender.send(order);
	}
}
