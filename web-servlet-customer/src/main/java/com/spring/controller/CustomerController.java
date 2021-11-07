package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String index(Model model) {
		
		// getfrom DB
		List<Customer> customers = customerDao.getAll();
		customers.forEach(System.out::println);
		model.addAttribute("customers", customers);
		
		return "customer/index";
	}
}
