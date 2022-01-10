package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Employee;

/* No need @Repository */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// @Query("FROM employee")
	// public List<Employee> getAll();
	
}
