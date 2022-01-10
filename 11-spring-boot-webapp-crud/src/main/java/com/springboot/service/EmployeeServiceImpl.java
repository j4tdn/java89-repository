package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeRepository;
import com.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	/** No need @Transactional */
	public List<Employee> getAll() {
		// do others by yourself
		return employeeRepository.findAll();
	}
}
