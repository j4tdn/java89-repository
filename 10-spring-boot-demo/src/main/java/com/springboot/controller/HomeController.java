package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "Happy new year - 08.01.2022";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Java - Spring course - 2022";
	}
	
}
