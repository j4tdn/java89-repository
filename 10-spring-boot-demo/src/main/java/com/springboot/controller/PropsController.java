package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("props")
public class PropsController {
	
	@Value("${student.username}")
	private String username;
	
	@Value("${student.age}")
	private int age;
	
	@GetMapping("")
	public String custom() {
		return username + ", " + age;
	}
	
}
