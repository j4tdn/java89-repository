package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}

	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String error403() {
		return "access-denied";
	}
}
