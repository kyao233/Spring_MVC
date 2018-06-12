package com.mybatis.domain;

public class Address {

	private int addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	public int getAddr_id() {
		return addrId;
	}
	public void setAddr_id(int addr_id) {
		this.addrId = addr_id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
