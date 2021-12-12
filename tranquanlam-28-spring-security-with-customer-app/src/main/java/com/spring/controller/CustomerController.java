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

	@GetMapping(value = { "", "/{orderBy}" })
	public String index(Model model, @PathVariable(required = false, value = "orderBy") String orderByLink) {
		SortOrder sortOrder = new SortOrder();
		System.out.println(orderByLink);
		if (orderByLink == null) {
			sortOrder.addParam(Customer.FIRST_NAME, true);

		} else {
			orderByLink = SortUtils.CUSTOMER_ORDER_MAP.get(orderByLink);
			sortOrder.addParam(orderByLink, true);
			if (orderByLink.equals(Customer.FIRST_NAME)) {
				sortOrder.addParam(Customer.LAST_NAME, true);
			} else if (orderByLink.equals(Customer.LAST_NAME)) {
				sortOrder.addParam(Customer.FIRST_NAME, true);
			}

		}
		List<Customer> customers = customerService.getAll(sortOrder);
		model.addAttribute("customers", customers);
		System.out.println(customers.size());
		return "customer/index";
	}

	@GetMapping("/search")
	public String search(@RequestParam("param") String searchValue, Model model) {
		if (searchValue == null || searchValue.trim().isEmpty()) {
			return "redirect:/customer";
		}

		List<Customer> customers = customerService.search(searchValue);
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

//	@GetMapping("/delete/{param}")
//	public String delete(@PathVariable("param") int param) {
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int customerId) {
		customerService.delete(customerId);
		return "redirect:/customer";
	}
}
