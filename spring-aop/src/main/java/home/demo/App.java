package home.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import home.service.MovieService;

public class App {
	
	private static final String CONFIG_PATH= "aop-jointpoint-advice-pointcut-auto-proxy.xml";
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
		
		// Not auto create proxy
//		MovieService service = context.getBean("movieServiceProxy", MovieService.class);
		
		// Get joint point bean auto create proxy
		MovieService service = context.getBean("movieService", MovieService.class);
		service.printName();
		context.close();
	}
}
