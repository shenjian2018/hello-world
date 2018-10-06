package com.rabbitmq.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.rabbitmq.model.BrokerMessageLogPO;
/**
 * 
 * <p>Title: BrokerMessageLogDao</p>  
 * <p>Description: </p>  
 * @author shenjian
 * @date 2018年10月6日
 */
@MapperScan
@Repository
public interface BrokerMessageLogDao {
	/**
	 * 创建消息日志
	 *
	 * @param messageLogPO
	 *            消息日志
	 */
	void insert(BrokerMessageLogPO messageLogPO);

	/**
	 * 更新消息状态
	 *
	 * @param messageLogPO
	 *            消息日志
	 */
	void changeBrokerMessageLogStatus(BrokerMessageLogPO messageLogPO);

	/**
	 * 查询消息状态为0 且 已经超时的消息
	 *
	 * @return 消息日志集合
	 */
	List<BrokerMessageLogPO> listSendFailureAndTimeoutMessage();

	/**
	 * 更新重试次数+1
	 *
	 * @param po
	 *            消息日志
	 */
	void updateRetryCount(BrokerMessageLogPO po);
}
