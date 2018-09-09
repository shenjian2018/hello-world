package com.jsm.produce;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	private static final String url = "tcp://192.168.0.100:61616";
	private static final String queneName = "quene-test";

	public static void main(String[] args) {
		// 1.创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection =null;
		
			// 2.创建连接
		 try {
			// 3.连接开始
			connection = connectionFactory.createConnection();
			connection.start();
			
			// 4.创建会话
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			// 5.目标对象
			Destination destination = session.createQueue(queneName);
			//6.创建一个消费者
			MessageConsumer consumer = session.createConsumer(destination);
			//7.创建一个监听器
			consumer.setMessageListener(new MessageListener() {				
				@Override
				public void onMessage(Message message) {
					  TextMessage  textMessage=(TextMessage) message;
					try {
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (JMSException e) {
			e.printStackTrace();
		}
            
			
		
			
		
	}

}
