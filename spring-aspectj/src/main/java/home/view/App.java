package home.view;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.AppConfig;
import home.service.MovieService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MovieService movieService = context.getBean("movieService", MovieService.class);
		movieService.getMovie();
		
		context.close();
	}
}
