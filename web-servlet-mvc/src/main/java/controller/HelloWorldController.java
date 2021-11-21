package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String show() {
		return "helloword-form";
	}
	
	@RequestMapping("/processForm")
	public String process() {
		return "helloword";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest req, Model model) {
		String theName = req.getParameter("studentName");
		String message = "Helle ! " + theName.toUpperCase();
		model.addAttribute("message", message);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		String message = "Helle ! " + theName.toUpperCase();
		model.addAttribute("message", message);
		return "helloworld";
	}
}
