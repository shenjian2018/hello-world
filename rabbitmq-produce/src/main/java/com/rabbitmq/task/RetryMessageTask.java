package com.rabbitmq.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.rabbitmq.Constant.Constants;
import com.rabbitmq.dao.BrokerMessageLogDao;
import com.rabbitmq.model.BrokerMessageLogPO;
import com.rabbitmq.model.OrderPO;
import com.rabbitmq.producer.OrderSender;
import com.rabbitmq.util.FastJsonConvertUtils;

public class RetryMessageTask {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderSender orderSender;
	@Autowired
	private BrokerMessageLogDao brokerMessageLogDao;
	
	 /**
     * 启动完成3秒后开始执行，每隔10秒执行一次
     */
    @Scheduled(initialDelay = 3000, fixedDelay = 10000)
    public void retrySend() {
        logger.debug("重发消息定时任务开始");
        // 查询 status = 0 和 timeout 的消息日志
        List<BrokerMessageLogPO> pos = this.brokerMessageLogDao.listSendFailureAndTimeoutMessage();
        for (BrokerMessageLogPO po : pos) {
            logger.debug("处理消息日志：{}",po);
            if (po.getTryCount() >= Constants.MAX_RETRY_COUNT) {
                // 更新状态为失败
                BrokerMessageLogPO messageLogPO = new BrokerMessageLogPO();
                messageLogPO.setMessageId(po.getMessageId());
                messageLogPO.setStatus(Constants.OrderSendStatus.SEND_FAILURE);
                this.brokerMessageLogDao.changeBrokerMessageLogStatus(messageLogPO);
            } else {
                // 进行重试，重试次数+1
                this.brokerMessageLogDao.updateRetryCount(po);
                OrderPO reSendOrder = FastJsonConvertUtils.convertJsonToObject(po.getMessage(), OrderPO.class);
                try {
					this.orderSender.send(reSendOrder);
                } catch (Exception ex) {
                    // 异常处理
                    logger.error("消息发送异常：{}", ex);
                }
            }
        }
        logger.debug("重发消息定时任务结束");
    }

}
