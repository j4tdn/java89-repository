package com.spring.service;

import java.util.List;

import com.spring.model.Customer;

public interface CustomerRestServiceClient {

	List<Customer> getAll();

	List<Customer> getAll(String orderByLink);

	Customer get(int customerId);

	void save(Customer theCustomer);

	void delete(int customerId);

}
