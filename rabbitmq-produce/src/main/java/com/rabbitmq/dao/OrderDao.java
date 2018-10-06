package com.rabbitmq.dao;

import org.springframework.stereotype.Repository;

import com.rabbitmq.model.OrderPO;
@Repository
public interface OrderDao {

	/**
	 * 新增
	 *
	 * @param order
	 *            订单
	 */
	void insert(OrderPO order);

}