package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getAll() {
		
		return customerDao.getAll();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		 customerDao.save(customer);
		
	}
	@Override
	@Transactional
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return customerDao.get(id);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		 customerDao.delete(id);
	}

	@Override
	@Transactional
	public List<Customer> search(String param) {
		// TODO Auto-generated method stub
		return customerDao.search(param);
	}
	
	
	@Override
	@Transactional
	public List<Customer> getAll(SortOrder sortOrder) {
		// TODO Auto-generated method stub
		return customerDao.getAll(sortOrder);
	}
	
}
