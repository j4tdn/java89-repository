package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Customer;
import com.spring.rest.exception.handler.EntityNotFoundException;
import com.spring.rest.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	// end-point GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getAll();
		
	}
	
	// end-point GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.get(customerId);
		if (customer == null) {
			throw new EntityNotFoundException("Customer id not found - " + customerId);
		}
		return customer;
	}
	
	// end-point POST /customers - add new customer
	@PostMapping("/customers")
	public Customer add(@RequestBody Customer customer) {
		// JSON can have ID(non-null, non-zero) or null valid
		// Override id=0 to make sure with POST method we will ignore ID and always add new customer
		customer.setId(0);
		customerService.save(customer);
		return customer;
	}
	
	// end-point PUT /customers - update existing customer
	
	@PutMapping("/customers")
	public Customer update(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
		
	}
	
	// end-point DELETE /customers/{customerId} - delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.get(customerId);
		
		if (tempCustomer == null) {
			throw new EntityNotFoundException("Customer id not found - " + customerId);
		}
				
		customerService.delete(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
}


















