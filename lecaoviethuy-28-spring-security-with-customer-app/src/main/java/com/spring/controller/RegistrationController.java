package com.spring.controller;

import java.util.logging.Logger;

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
	
	private Logger logger = java.util.logging.Logger.getLogger(getClass().getName());
	
	@Autowired
	UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimerEditor);
	}

	@GetMapping("/signUp")
	public String signup(Model model) {
		model.addAttribute("user", new UserModel());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String processRegistrationForm(@Valid @ModelAttribute("user") UserModel userModel,
			BindingResult theBindingResult, Model theModel) {

		String userName = userModel.getUserName();
		logger.info("registering ...  " + userName);

		// form validation
		if (theBindingResult.hasErrors()) {
			return "signup";
		}

		// check the database if user already exists
		User existing = userService.findByUserName(userName);
		if (existing != null) {
			theModel.addAttribute("crmUser", userModel);
			theModel.addAttribute("registrationError", "User name already exists.");

			return "signup";
		}
		
		userService.save(userModel);

		return "/login";
	}
	
}
