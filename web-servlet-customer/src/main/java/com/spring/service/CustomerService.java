package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerService {
	List<Customer> getAll();
	void save(Customer customer);
	Customer get(int customerId);
	void delete(int customerId);
	List<Customer> find(String value);
	List<Customer> getAllSorted(String sorting);
	List<Customer> getAll(SortOrder sortOrder);
}
