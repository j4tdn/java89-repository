package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("helloworld")
public class HelloWroldController {
	@RequestMapping("/show")
	public String show() {
		return "helloworld-form";
	}
	@RequestMapping("/processForm")
	
	public String process() {  
		return "helloworld";
	} 
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request,Model model) {
		//get from value
		String theName = request.getParameter("studentName");
		//execution
		//handle
		String message ="hello !"+theName.toUpperCase();
		//add to model
		model.addAttribute("message",message);
		return "helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		//get from value
		
		//execution
		String message ="greet !"+theName.toUpperCase();
		model.addAttribute("message",message);
		return "helloworld";
	}
}
