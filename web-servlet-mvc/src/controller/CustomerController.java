package controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Customer;



@Controller
@RequestMapping("customer")
public class CustomerController {

	@InitBinder
	public void preHandler(WebDataBinder databinder) {
		
		StringTrimmerEditor stringEditor = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringEditor);
		
	}
	@RequestMapping("/show")
	public String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		return "customer/customer-form";
	}
	@RequestMapping("/processForm")
	public String showForm(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult) {
		System.out.println("binding result: "+bindingResult);
		System.out.println("\n\n\n");
		return bindingResult.hasErrors()?"customer/customer-form":"customer/customer";
	}
}
