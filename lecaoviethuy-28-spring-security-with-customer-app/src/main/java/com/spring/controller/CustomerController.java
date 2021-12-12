package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = {"", "/"})
	public String index(Model model) {
		
		List<Customer> customers = customerService.getAll();
		customers.forEach(System.out::println);
		model.addAttribute("customers", customers);
		
		return "customer/index";
	}

	@RequestMapping("/add")
	public String showFormForAdd(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/form";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/";
	}

	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int customerId, Model model) {
		Customer customer = customerService.get(customerId);
		
		model.addAttribute("customer", customer);
		return "customer/form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		customerService.delete(id);
		
		return "redirect:/customer";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("q") String searchValue, Model model) {
		if (searchValue == null || searchValue.trim().isEmpty()) {
			return "redirect:/customer";
		}
		
		searchValue = searchValue.trim();
		List<Customer> customers = customerService.search(searchValue);
		
		model.addAttribute("customers", customers);
		model.addAttribute("q", searchValue);
		
		return "customer/index";
	}
}
