package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/home" })
	public String home() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}
	
}
