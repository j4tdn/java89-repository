package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerService {
	List<Customer> getAll();

	void save(Customer customer);

	  Customer get(int customerId) ;
}
