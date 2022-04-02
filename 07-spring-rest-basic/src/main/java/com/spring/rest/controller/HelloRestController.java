package com.spring.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class HelloRestController {

	@GetMapping("/hello")
	public String hello() {
		return "Spring REST - Hello world";
	}
	
}
