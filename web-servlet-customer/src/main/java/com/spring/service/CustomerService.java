package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerService {
	List<Customer> getAll();

	void save(Customer customer);

	  Customer get(int customerId) ;


	void delete(int id);

	List<Customer> search(String searchValue);

	List<Customer> getAll(SortOrder sortOrder);
}
