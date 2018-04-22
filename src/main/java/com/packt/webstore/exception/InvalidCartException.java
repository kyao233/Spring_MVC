package com.packt.webstore.exception;

import java.io.Serializable;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class InvalidCartException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2905934165505063233L;

	private String cartId;
	
	public InvalidCartException(String cartId) {
		this.cartId = cartId;
	}
	
	public String getCartId() {
		return cartId;
	}
	
}
