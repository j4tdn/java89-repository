package com.spring.service;

import java.util.List;

import com.spring.model.Customer;

import pagination.Pagable;

public interface CustomerRestClient {

	Pagable<Customer> getAll(String sort, int page);
	
	/**
	 * Pagination
	 */
	int countTotalElements();
	
	List<Customer> search(String keyword);
	
	/**
	 * Pagination
	 */
	int countTotalElements(String keyword);

	Customer get(int customerId);

	void save(Customer theCustomer);

	void delete(int customerId);

	
	
}
