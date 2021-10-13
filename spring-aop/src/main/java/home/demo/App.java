package home.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import home.service.MovieService;

public class App {
	private static final String CONFIG_PATH = "aop-joinpoint-advice-pointcut-autoproxy.xml";

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
		MovieService service = context.getBean("movieService", MovieService.class);
		service.printName();
		// service.printCatalog();

//		App app = new App();
//		Method method = app.getClass().getDeclaredMethod("testing");
//		method.setAccessible(true);
//		method.invoke(app);
//		context.close();
//	}
//	private void testing() {
//		System.out.println("========================================");
		
	}
}
