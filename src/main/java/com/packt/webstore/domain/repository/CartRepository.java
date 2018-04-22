package com.packt.webstore.domain.repository;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Cart;


@Repository
public interface CartRepository {

	Cart create(Cart cart);
	
	Cart read(String CartId);
	
	void update(String cartId, Cart cart);
	
	void delete(String cartId);
	
}
