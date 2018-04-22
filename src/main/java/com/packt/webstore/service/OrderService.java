package com.packt.webstore.service;

import com.packt.webstore.domain.Order;

public interface OrderService {

	public void processOrder(String productId, int count);
	
	public Long saveOrder(Order order);
	
}
