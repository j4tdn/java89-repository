package com.springboot.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	@GetMapping("/tml")
	public String tmlpage(ModelMap model) {
		model.addAttribute("today", LocalDate.now());
		// default: src/main/resources/templates + thymeleaf + .html
		return "thymeleaf";
	}
}
