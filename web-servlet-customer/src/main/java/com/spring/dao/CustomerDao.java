package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerDao {
	List<Customer> getAll();
	void save(Customer customer);
	Customer get(int customerId);
	void delete(int customerId);
	List<Customer> find(String value);
	List<Customer> getAll(SortOrder sortOrder);
}
