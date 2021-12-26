package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.entity.Customer;
import com.spring.rest.sorting.SortOrder;

public interface CustomerDao {
	List<Customer> getAll();

	Customer get(int id);

	void save(Customer customer);

	void delete(int id);

	List<Customer> search(String param);

	List<Customer> getAll(SortOrder sortOrder);
}
