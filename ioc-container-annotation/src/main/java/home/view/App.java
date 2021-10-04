package home.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import home.bean.MovieRecomender;
import home.configuration.AppConfig;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		printBeans(context);
		System.out.println("=================");
		
		MovieRecomender recomender = context.getBean("movieRecomender", MovieRecomender.class);
		recomender.showHotMovie();
		
		context.close();
	}
	
	private static void printBeans(ApplicationContext context) {
		String[] beans = context.getBeanDefinitionNames();
		for (String bean: beans) {
			System.out.println(bean);
		}
	}
}
