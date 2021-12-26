package com.spring.rest.service;

import java.util.List;

import com.spring.rest.entity.Customer;
import com.spring.rest.sorting.SortOrder;

public interface CustomerService {
	List<Customer> getAll();
	List<Customer> getAll(SortOrder sortOrder);
	void save(Customer customer);
	Customer get(int customerId);
	void delete(int id);
	List<Customer> search(String param);
	
}
