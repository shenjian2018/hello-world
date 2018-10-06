package com.rabbitmq.model;

import java.io.Serializable;

/**
 * <p>
 * Title: OrderPO
 * </p>
 * <p>
 * Description:
 * </p>
 * @author shenjian
 * @date 2018年9月24日
 */
public class OrderPO implements Serializable {

	private static final long serialVersionUID = 5486577676540116697L;

	private String id;
	private String name;
	private String messageId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "OrderPO [id=" + id + ", name=" + name + ", messageId=" + messageId + "]";
	}

}
