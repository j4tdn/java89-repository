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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Customer;
import com.spring.rest.exception.handler.EntityNotFoundException;
import com.spring.rest.service.CustomerService;

import pagination.Pagable;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	// GET /customers?sort=firstName,desc
	// GET /customers?sort=firstName >> default as asc
	
	@GetMapping("/customers")
	public Pagable<Customer> getCustomers(
			@RequestParam(value = "sort", defaultValue = "firstName,asc") String sort,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		// SORTING
		String sortProperty = sort;
		Boolean sortDirection = true;
		// sort=firstName, descending
		if (sort != null && sort.contains(",")) {
			String[] sortParams = sort.split(",");
			if (sortParams.length == 2) {
				sortProperty = sortParams[0];
				sortDirection = sortParams[1].equalsIgnoreCase("asc");
			}
		}
		
		// PAGINATION
		// Step 1: count total of elements
		int totalElements = customerService.countTotalElements();
		int elementsPerPage = 6; // could be configured

		// Step 2: count total of pages and sent to UI page
		int totalPages = (int) Math.ceil((float) totalElements / elementsPerPage);

		// Step 3: get offset, row count=elementsPerPage
		int offset = (page - 1) * elementsPerPage;
				
		// Step 4: get data base of current page (offset, row count)
		return new Pagable<>(customerService.getAll(sortProperty, sortDirection, offset, elementsPerPage), totalPages);
	}
	
	@GetMapping("/customers/total-elements") 
	public int countTotalElements() {
		return customerService.countTotalElements();
	}
	
	// NOW: GET http://localhost:8080/08-spring-crm-rest-api/api/customers/filter?search=david
	@GetMapping("/customers/filter")
	public List<Customer> search(@RequestParam("search") String keyword) {
		return customerService.search(keyword);
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
		// Override id=0 to make sure with POST method we will ignore ID and always add
		// new customer
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
