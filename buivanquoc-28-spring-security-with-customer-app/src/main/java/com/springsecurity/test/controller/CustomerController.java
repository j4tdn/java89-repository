package com.springsecurity.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.test.entity.Customer;
import com.springsecurity.test.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the dao
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", customers);

		return "customer/index";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer/form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "customer/form";
		} else {
			// save the customer using our service
			customerService.saveCustomer(theCustomer);

			return "redirect:/customer/list";
		}

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer/form";
	}

//	@GetMapping("/delete")
//	public String deleteCustomer(@RequestParam("customerId") int theId) {
//		
//		// delete the customer
//		customerService.deleteCustomer(theId);
////		redirect customer/list
//		return "redirect:/customer/list";
//	}

	@GetMapping("/delete/{param}")
	public String deleteCustomer(@PathVariable("param") int id) {

		// delete the customer
		customerService.deleteCustomer(id);
//		redirect customer/list
		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String searchCustomer(@RequestParam(name = "param", required = false) String value, Model model) {
		if (value == null || value.trim().isEmpty()) {
			return "redirect:/customer/list";
		}

		List<Customer> customers = customerService.searchCustomer(value);
		model.addAttribute("customers", customers);
		customers.forEach(System.out::println);
		return "customer/index";
	}

}
