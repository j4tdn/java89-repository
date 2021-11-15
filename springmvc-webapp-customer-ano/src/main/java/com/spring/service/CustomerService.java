package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

public interface CustomerService {

	List<Customer> getCustomers();
	
	List<Customer> getCustomers(SortOrder sortOrder);

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);

	List<Customer> searchCustomers(String searchValue);

}
