package com.springsecurity.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.demo.entity.Customer;
import com.springsecurity.demo.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerPageController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = {"", "/"})
	public String index(Model model) {
		
		List<Customer> customers = customerService.getAll();
		customers.forEach(System.out::println);
		model.addAttribute("customers", customers);
		
		return "customer-page";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		customerService.delete(id);
		
		return "redirect:/customer";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("nameCustomer") String searchValue, Model model) {
		if (searchValue != null) {
			searchValue = searchValue.trim();
			List<Customer> customers = customerService.search(searchValue);
			
			model.addAttribute("customers", customers);
			model.addAttribute("nameCustomer", searchValue);
			
			return "customer-page";
		} else {
			return "redirect:/customer";
		}
	}
}