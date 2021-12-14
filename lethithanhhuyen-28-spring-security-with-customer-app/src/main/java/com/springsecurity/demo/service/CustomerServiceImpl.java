package com.springsecurity.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.demo.dao.CustomerDao;
import com.springsecurity.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public Customer get(int id) {
		return customerDao.get(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}

	@Override
	@Transactional
	public List<Customer> search(String name) {
		return customerDao.search(name);
	};
}