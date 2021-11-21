package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
	public String show(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("countries", new String[] {"VietNam","Brazil"});
		return "student/student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("Binding: " + student.getFirstName() +", " + student.getLastName()+", " + student.getCountry());
		return "student/student";
	}
}
