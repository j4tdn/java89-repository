package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerService {
	List<Customer> getAll(SortOrder sortOrder);
	List<Customer> search(String param);
	void save(Customer customer);
	void delete(int customerId);
	Customer get(int customerId);
	
}
