package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	// need a controller method to handle http://localhost:8080/web-servlet-mvc
	@RequestMapping({"/", "/student"})
	public String index() {
		return "home";
	}
}
