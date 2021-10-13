package home.view;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import configuration.AppConfig;
import home.service.MovieService;

public class App {
	public static void main(String[] args) {
		//ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		MovieService sevice = context.getBean("movieService", MovieService.class);
		sevice.addMovie();
		
		context.close();
	}
}
