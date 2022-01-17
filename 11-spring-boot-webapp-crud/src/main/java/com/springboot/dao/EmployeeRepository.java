package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.entity.Employee;

/* No need @Repository */
// Spring data REST --->> create REST end points /employees
@RepositoryRestResource(path = "staff")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// @Query("FROM employee")
	// public List<Employee> getAll();
	
}
