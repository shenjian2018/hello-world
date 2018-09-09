package com.jsm.produce;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsDemo {
	private static final String url = "tcp://192.168.0.100:61616";
	private static final String queneName = "quene-test";

	public static void main(String[] args) {
		// 1.创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection =null;
		try {
			// 2.创建连接
		 connection = connectionFactory.createConnection();
			// 3.连接开始
			connection.start();
			// 4.创建会话
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			// 5.目标对象
			Destination destination = session.createQueue(queneName);
            //6.创建一个生产者
			MessageProducer producer = session.createProducer(destination);
			for (int i = 0; i < 100; i++) {
				//7.创建消息
				TextMessage textMessage = session.createTextMessage("test"+i);
				//8。发布消息
				producer.send(textMessage);	
				System.out.println("发送消息"+textMessage.getText());
			}		
			if (connection!=null) {
				connection.close();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
			
		
	}

}
