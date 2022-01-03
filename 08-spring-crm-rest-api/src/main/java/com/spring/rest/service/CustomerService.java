package com.spring.rest.service;

import java.util.List;

import com.spring.rest.entity.Customer;

public interface CustomerService {
	List<Customer> getAll();
	
	List<Customer> getAll(String sortProperty, Boolean sortDirection);
	
	List<Customer> getAll(String sortProperty, Boolean sortDirection, int offset, int elementsPerPage);
	
	int countTotalElements();
	
	List<Customer> search(String keyword);
	
	Customer get(int customerId);
	
	void save(Customer customer);
	
	void delete(int id);

	

}
