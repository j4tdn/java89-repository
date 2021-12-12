package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
public class HomeController {
	
	@GetMapping({"",  "/"})
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("leaders")
	public String leaders() {
		return "leaders";
	}
	
	@GetMapping("systems")
	public String systems() {
		return "systems";
	}
}
