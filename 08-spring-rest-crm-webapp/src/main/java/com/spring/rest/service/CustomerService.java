package com.spring.rest.service;

import java.util.List;

import com.spring.rest.entity.Customer;

public interface CustomerService {
	List<Customer> getAll();
	List<Customer> getAll(String sortBy, boolean isAsc);
	void save(Customer customer);
	Customer get(int customerId);
	void delete(int id);
	List<Customer> search(String param);
	
}
