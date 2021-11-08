package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String index(Model model) {
		
		// getfrom DB
		List<Customer> customers = customerService.getAll();
		customers.forEach(System.out::println);
		model.addAttribute("customers", customers);
		
		return "customer/index";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("customer",new Customer());
	
		
		return "customer/form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int customerId, Model model) {
		//get customer from database
		Customer customer = customerService.get(customerId);
		
		//add model attribute
		model.addAttribute("customer",customer);
	
		 
		return "customer/form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute ("customer") Customer customer) {
		customerService.save(customer);
		
		return "redirect:/customer/list";
	}
}
