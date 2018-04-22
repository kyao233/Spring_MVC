package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomer = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
		Customer custJane = new Customer("C1234", "Jane", "Chicago", true);
		Customer custJessie = new Customer("C4321", "Jessie", "Chicago", true);
		listOfCustomer.add(custJessie);
		listOfCustomer.add(custJane);
	}
	
	public List<Customer> getAllCustomers() {
		return listOfCustomer;
	}

}
