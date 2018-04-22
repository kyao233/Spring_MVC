package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

	private Map<Long, Order> orderList;
	private long nextOrderId;
	
	public InMemoryOrderRepository() {
		orderList = new HashMap<Long, Order>();
		nextOrderId = 10000; 
	}
	
	@Override
	public Long saveOrder(Order order) {
		order.setOrderId(getNextOrderId());
		orderList.put(order.getOrderId(), order);
		return order.getOrderId();
	}
	
	private long getNextOrderId() {
		return nextOrderId++;
	}
	

}
