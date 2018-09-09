package com.jsm.produce;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProduceSeviceImp implements ProduceSevice {

	@Autowired
	JmsTemplate jmsTemplate;
	@Resource(name = "queueDestination")
	Destination destination;

	@Override
	public void sendMessage(final String message) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				return textMessage;
			}
		});
		System.out.println(message);
	}

}
