package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.User;
import com.spring.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

	@GetMapping({"/"})
	public String welcome() {
		System.out.println("hello");
		return "welcome";
	}
	
	@GetMapping({"/home"})
	public String home() {
		System.out.println("home");
		return "home";
	}
	
	@GetMapping({"/customer"})
	public String customer(Model model) {
		List<User> lists = userService.getAllUsers();
		model.addAttribute("users", lists);
		return "customer";
	}
	
	@GetMapping({"/customer/add"})
	public String addCustomer(Model model) {
		model.addAttribute("customer", new User());
		return "form-add-customer";
	}
	
	@PostMapping({"/customer/save"})
	public String saveCustomer(Model model) {
		model.addAttribute("customer", new User());
		return "form-add-customer";
	}
}
