package com.packt.webstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Product;

import junit.framework.Assert;

public class CartTest {

	private Cart cart;
	
	@Before
	public void setup() {
		cart = new Cart();
	}
	
	
	@Test
	public void cart_grand_total_price_should_be_equal_to_cart_total_price_in_case_of_one_product() {
		//arrange
		Product iphone = new Product("P1234", "iphone 5s", new BigDecimal(500));
		CartItem cartItem = new CartItem(iphone);
		Map<String, CartItem> cartitems = new HashMap<String, CartItem>();
		cartitems.put(cartItem.getProduct().getProductId(), cartItem);
		cart.setCartItems(cartitems);
		
		//act
		BigDecimal grandTotal = cart.getGrandTotal();
		
		
		//assert
		
		Assert.assertEquals(cartItem.getTotalPrice(), grandTotal);
		
		
	}
	
}
