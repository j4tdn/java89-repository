package com.spring.controller;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;
import com.spring.sorting.SortOrder;
import com.spring.sorting.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;

	// Using Java
	// @RequestMapping(value = { "/index", "/index/{orderBy}" })
	public String listCustomers(Model theModel, @PathVariable(required = false, value = "orderBy") String orderBy) {

		// get customers from the dao
		List<Customer> customers = customerService.getCustomers();

		if (orderBy != null) {
			System.out.println("orderBy: " + orderBy);
			Function<Customer, String> function = null;
			switch (orderBy) {
			case "orderByFirstName":
				function = Customer::getFirstName;
				break;
			case "orderByLastName":
				function = Customer::getLastName;
				break;
			case "orderByEmail":
				function = Customer::getEmail;
				break;
			}
			customers = customers.stream().sorted(Comparator.comparing(function)).collect(Collectors.toList());
		}

		// add the customers to the model
		theModel.addAttribute("customers", customers);

		return "customer/index";
	}

	// Using SQL
	@RequestMapping(value = { "", "/", "/{orderBy}" })
	public String listCustomers1(Model theModel, @PathVariable(required = false, value = "orderBy") String sortParam) {
		SortOrder sortOrder = null;
		
		if (sortParam == null) {
			// default sort order
			sortOrder = new SortOrder().addParam("first_name", true);
		} else {
			// sort by ui
			sortOrder = new SortOrder().addParam(SortUtils.CUSTOMER_ORDER_MAP.get(sortParam), true);
			if (sortParam.equals("orderByFirstName")) {
				sortOrder.addParam(SortUtils.CUSTOMER_ORDER_MAP.get("orderByLastName"), true);
			}
		}
		
		// get customers from the dao
		List<Customer> customers = customerService.getCustomers(sortOrder);

		// add the customers to the model
		theModel.addAttribute("customers", customers);

		return "customer/index";
	}

	@GetMapping("/add")
	public String add(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer/form";
	}

	// @GetMapping("/update/{id}")
	// public String update(@PathVariable("id") int theId, Model theModel) {

	@GetMapping("/update")
	public String update(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer/form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// delete the customer
		customerService.deleteCustomer(theId);

		return "redirect:/customer";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("searchName") String searchValue, Model model) {
		if (searchValue == null || searchValue.trim().isEmpty()) {
			return "redirect:/customer";
		}

		// search customers from the service
		List<Customer> customers = customerService.searchCustomers(searchValue);

		// add the customers to the model
		model.addAttribute("customers", customers);
		return "customer/index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer";
	}

}
