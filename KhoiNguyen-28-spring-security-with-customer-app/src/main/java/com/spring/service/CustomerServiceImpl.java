package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;

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
	public Customer get(int customerId) {
		return customerDao.get(customerId);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		customerDao.delete(customerId);
	}

	@Override
	@Transactional
	public List<Customer> search(String searchValue) {
		return customerDao.search(searchValue);
	};
}