package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
}
