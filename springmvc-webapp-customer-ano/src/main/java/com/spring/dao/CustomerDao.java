package com.spring.dao;

import java.util.List;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;


public interface CustomerDao {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);

	List<Customer> searchCustomers(String searchValue);

	List<Customer> getCustomers(SortOrder sortOrder);
	
}
