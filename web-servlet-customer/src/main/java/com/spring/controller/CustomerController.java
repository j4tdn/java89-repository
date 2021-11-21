package com.spring.controller;

import java.util.List;

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
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = {"","/", "/{orderBy}"})
	public String index(Model model, @PathVariable(required = false, value = "orderBy") String orderByLink) {
		
		List<Customer> customers = customerService.getAll(getSortOrder(orderByLink));
		
		model.addAttribute("customers", customers);
		
		return "customer/index";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/form";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int customerId, Model model) {
		Customer customer = customerService.get(customerId);
		
		model.addAttribute("customer", customer);
		return "customer/form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customer";
	}
	
//	@GetMapping("/delete")
//	public String deleteCustomer(@RequestParam("id") int customerId) {
//		customerService.delete(customerId);
//		return "redirect:/customer/list";
//	}
	
	@GetMapping("/delete/{param}")
	public String deleteCustomer(@PathVariable("param") int customerId) {
		System.out.println(customerId);
		customerService.delete(customerId);
		return "redirect:/customer";
	}
	
	@GetMapping("/find")
	public String findCustomer(@RequestParam("value") String value, Model model) {
		List<Customer> customers = customerService.find(value);
		customers.forEach(c->{
			System.out.println(c.getFirstName()+"-");
		});
		model.addAttribute("customers", customers);
		return "customer/index";
	}
	
	@GetMapping("/sort")
	public String sortCustomers(@RequestParam("sorting") String sorting, Model model) {
		List<Customer> customers = customerService.getAllSorted(sorting);
		model.addAttribute("customers", customers);
		return "customer/index";
	}
	
	private SortOrder getSortOrder(String orderByLink) {
		
		SortOrder sortOrder = null;
		
		if(orderByLink == null) {
			sortOrder = new SortOrder().addParam(Customer.FIRST_NAME, true);
		} else {
			String sortProperty = SortUtils.CUSTOMER_ORDER_MAP.get(orderByLink);
			sortOrder = new SortOrder().addParam(sortProperty, true);
			
			if(sortProperty.equals(Customer.FIRST_NAME)) {
				sortOrder.addParam(Customer.LAST_NAME, true);
			} else if(sortProperty.equals(Customer.LAST_NAME)) {
				sortOrder.addParam(Customer.FIRST_NAME, true);
			}
		
		}
		return sortOrder;
		
	}
}
