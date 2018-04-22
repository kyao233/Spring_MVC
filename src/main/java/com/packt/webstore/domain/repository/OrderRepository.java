package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Order;

public interface OrderRepository {
	
	public Long saveOrder(Order order);
	
}
