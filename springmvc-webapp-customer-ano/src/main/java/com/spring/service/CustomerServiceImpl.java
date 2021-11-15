package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomers(SortOrder sortOrder) {
		return customerDao.getCustomers(sortOrder);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDao.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDao.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchValue) {
		return customerDao.searchCustomers(searchValue);
	}
}
