package com.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.User;
import com.spring.model.UserModel;
import com.spring.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
//	trach ky tu rong, validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new UserModel());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String processForm(@Valid @ModelAttribute("user") UserModel userModel, 
			BindingResult bindingResult, Model model) {
		
//		form validation
		if(bindingResult.hasErrors()) {
			return "signup";
		}

		String username = userModel.getUserName();
		
//		check user exists in database
		User existing = userService.findByUserName(username);
		
		if(existing != null) {
			model.addAttribute("user", userModel);
			model.addAttribute("registrationError", "Username already exists");
			return "signup";
		}
		
		userService.save(userModel);
		
		return "signup-success";
		
	}
}
