package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerDao {
	List<Customer> getAll(SortOrder sortOrder);
	List<Customer> search(String param);
	void save(Customer customer);
	void delete(Customer customer);
	Customer get(int customerId);
}
