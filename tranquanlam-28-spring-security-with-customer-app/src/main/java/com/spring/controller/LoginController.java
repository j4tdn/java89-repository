package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
public class LoginController {
	@GetMapping("login")
	public String login() {
		System.out.println(RequestContextHolder.currentRequestAttributes());
		return "login";
	}

	@GetMapping("/access-denied")
	public String error403() {
		System.out.println(RequestContextHolder.currentRequestAttributes());
		return "access-denied";
	}

}
