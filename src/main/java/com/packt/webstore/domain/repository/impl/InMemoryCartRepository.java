package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;

@Repository
public class InMemoryCartRepository implements CartRepository {

	
	private Map<String, Cart> cartList;
	
	public InMemoryCartRepository() {
		cartList = new HashMap<String, Cart>();
	}
	
	
	@Override
	public Cart create(Cart cart) {
		String cartId = cart.getCartId();
		if(cartList.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not create a cart, A cart with given id (%s) already exist", cart.getCartId()));
		} 
		
		cartList.put(cartId, cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return cartList.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!cartList.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Can not update a cart, A cart with given id (%s) doesn't exist", cart.getCartId()));
		} 
		cartList.put(cartId, cart);	
	}

	@Override
	public void delete(String cartId) {
		if(!cartList.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Can not delete a cart, A cart with given id (%s) doesn't exist", cartId));
		} 
		cartList.remove(cartId);
	}
	
	
}
