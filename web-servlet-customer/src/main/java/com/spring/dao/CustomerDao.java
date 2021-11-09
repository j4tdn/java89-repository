package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerDao {
	List<Customer> getAll();

	void save(Customer customer);

	Customer get(int id);


	void delete(int id);

	List<Customer> search(String searchValue);

	List<Customer> getAll(SortOrder sortOrder);
	
}
