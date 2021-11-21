package com.spring.service;

import java.util.Comparator;
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
	public List<Customer> find(String value) {
		return customerDao.find(value);
	}
	
	@Override
	@Transactional
	public List<Customer> getAllSorted(String sorting) {
		List<Customer> customers = customerDao.getAll();
		if(sorting.equals("firstName")) {
			Comparator<Customer> comp = Comparator.comparing(customer -> customer.getFirstName());
			customers.sort(comp.thenComparing(customer -> customer.getLastName()).thenComparing(customer -> customer.getEmail()));
		} else if(sorting.equals("lastName")) {
			Comparator<Customer> comp = Comparator.comparing(customer -> customer.getLastName());
			customers.sort(comp.thenComparing(customer -> customer.getEmail()).thenComparing(customer -> customer.getFirstName()));
		} else {
			Comparator<Customer> comp = Comparator.comparing(customer -> customer.getEmail());
			customers.sort(comp.thenComparing(customer -> customer.getFirstName()).thenComparing(customer -> customer.getLastName()));
		}
		
		return customers;
	}
	
	@Override
	@Transactional
	public List<Customer> getAll(SortOrder sortOrder) {
		// TODO Auto-generated method stub
		return customerDao.getAll(sortOrder);
	}
}
