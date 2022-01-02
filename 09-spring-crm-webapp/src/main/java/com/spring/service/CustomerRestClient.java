package com.spring.service;

import java.util.List;

import com.spring.model.Customer;

public interface CustomerRestClient {

	List<Customer> getAll();

	List<Customer> getAll(String sort);
	
	List<Customer> search(String keyword);

	Customer get(int customerId);

	void save(Customer theCustomer);

	void delete(int customerId);

	

}
