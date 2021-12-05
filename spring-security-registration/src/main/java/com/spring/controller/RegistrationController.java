package com.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.model.UserModel;

@Controller
public class RegistrationController {
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new UserModel());
		return "registration";
	}
	
	@PostMapping("/signup")
	public String processForm(@Valid @ModelAttribute("user") UserModel userModel,
							BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		
		return  "signup-success";
	}
}
