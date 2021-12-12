package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Service
public class CustomerServiceIml implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	@Transactional
	public List<Customer> getAll(SortOrder sortOrder) {
		return dao.getAll(sortOrder);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		dao.save(customer);
	}

	@Override
	@Transactional
	public Customer get(int customerId) {
		return dao.get(customerId);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		dao.delete(dao.get(customerId));
	}

	@Override
	@Transactional
	public List<Customer> search(String param) {
	System.out.println(dao.search(param));
		return dao.search(param);
	}

}
