package com.springsecurity.demo.service;

import java.util.List;

import com.springsecurity.demo.entity.Customer;

public interface CustomerService {
	List<Customer> getAll();
	void save(Customer customer);
	Customer get(int id);
	void delete(int id);
	List<Customer> search(String name);
}