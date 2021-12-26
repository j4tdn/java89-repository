package com.spring.service;

import java.util.List;

import com.spring.model.Customer;

public interface CustomerService {

	public List<Customer> getAll();

	public Customer get(int customerId);

	public void save(Customer theCustomer);

	public void delete(int customerId);

}
