package home.view;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import home.bean.MovieRecomender;
import home.bean.Student;
import home.configuaration.AppConfig;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MovieRecomender recomender = context.getBean(MovieRecomender.class);
		System.out.println(recomender);
		context.close();
		
		
		Student student = new Student("Nguyen Van A", 18);
	}
}
