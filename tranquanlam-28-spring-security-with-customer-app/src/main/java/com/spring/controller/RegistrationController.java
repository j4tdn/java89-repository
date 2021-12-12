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

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

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

	@PostMapping("signup")
	public String processForm(@Valid @ModelAttribute("user") UserModel userModel, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "signup";
		}

		String userName = userModel.getUserName();
		logger.info("\n ***Processing register " + userName + "\n");
		// check user exists in database
		User exingting = userService.findByUserName(userName);
		
		// if user existed in database, inform error
		if (exingting != null) {
			logger.warning("\n *** Username already exists \n");
			model.addAttribute("registrationError", "Username already exists");
			model.addAttribute("user", userModel);
			return "signup";
		}
		
		userService.save(userModel);
		logger.info("\n *** Register Success \n");
		return "signup-success";
	}
}
