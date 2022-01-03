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

import com.spring.model.Customer;
import com.spring.service.CustomerRestClient;

import pagination.Pagable;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerRestClient customerService;

	@GetMapping(value = {"", "/"})
	public String getAll(Model model, 
			@RequestParam(value = "sort", defaultValue = "firstName") String sort,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		Pagable<Customer> customerPagable = customerService.getAll(sort, page);
		
		List<Customer> customers = customerPagable.getElements();
		int totalPages = customerPagable.getTotalPages();
		
		model.addAttribute("customers", customers);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);
		return "customer/index";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		if (keyword == null || keyword.trim().isEmpty()) {
			return "redirect:/customer";
		}
		
		List<Customer> customers = customerService.search(keyword.trim());
		model.addAttribute("customers", customers);
		return "customer/index";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/form";
	}

	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.get(id);
		model.addAttribute("customer", customer);
		return "customer/form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		customerService.delete(id);
		return "redirect:/customer";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customer";
	}
	
}
