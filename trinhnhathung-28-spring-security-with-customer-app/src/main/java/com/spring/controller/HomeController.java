package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping({ "/leaders" })
	public String leaders() {
		return "leaders";
	}

	@GetMapping({ "/systems" })
	public String systems() {
		return "systems";
	}

	@GetMapping("/customer")
	public String customer(Model model) {
		List<Customer> customers = customerService.getAll();
		model.addAttribute("customers", customers);
		return "customer";
	}
	
	@GetMapping("/addCustomer")
	public String getCustomer() {
		return "addCustomer";
	}
	
	@PostMapping("/addCustomer")
	public String postCustomer() {
		return "addCustomer";
	}
}
