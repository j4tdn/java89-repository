package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	@RequestMapping("/show")
	public String showForm(Model model) {
		
		//model attribute
		model.addAttribute("student",new Student());
		model.addAttribute("countries" ,new String[] {"brazil","franch","vietnam","india"});
		return "student/student-form";
	}
	
	@RequestMapping("/processForm")
	public String showForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("binding:"+theStudent.getFirstName()+","+theStudent.getLastName());
		//model attribute
		return "student/student";
	}
}
