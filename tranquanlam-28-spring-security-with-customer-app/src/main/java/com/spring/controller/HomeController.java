package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
public class HomeController {
	
	@GetMapping({ "/", "" })
	public String home() {
		System.out.println(RequestContextHolder.currentRequestAttributes());
		return "home";
	}
	
	@GetMapping ("/leaders")
	public String leaders() {
		System.out.println(RequestContextHolder.currentRequestAttributes());
		return "leaders";
	}
	
	@GetMapping ("/systems")
	public String systems() {
		System.out.println(RequestContextHolder.currentRequestAttributes());
		return "systems";
	}
}
