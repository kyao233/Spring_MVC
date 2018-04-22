package com.packt.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	
	
	private static final long serialVersionUID = 2284040482222162898L;
	
	private String customerId;
	private String name;
	private String address;
	private boolean noOfOrderMade;
	private Address billingAddress;
	private String phoneNumber;
	
	public Customer() {
		super();
		this.billingAddress = new Address();
	}
	
	public Customer(String customerId, String name, String address, boolean noOfOrderMade) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.noOfOrderMade = noOfOrderMade;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isNoOfOrderMade() {
		return noOfOrderMade;
	}
	public void setNoOfOrderMade(boolean noOfOrderMade) {
		this.noOfOrderMade = noOfOrderMade;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Customer other = (Customer)obj;
		
		if (other.getCustomerId() == null) {
			if (this.getCustomerId() == null) {
				return false;
			}
		} else if (!this.getCustomerId().equals(other.getCustomerId())) {
			return false;
		}
		
		return true;
		
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((customerId == null)? 0 : customerId.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + "]";
	}

}
