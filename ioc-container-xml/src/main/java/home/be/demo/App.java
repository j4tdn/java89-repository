package home.be.demo;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import home.be.bean.Item;
import home.be.service.ClientService;
import home.be.service.ItemService;

public class App {
	public static void main(String[] args) {
		// ioc container
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		// print beans in context container
		String[] beanNames = context.getBeanDefinitionNames();
//		Arrays.stream(beanNames).forEach(System.out::println);
		
		ItemService service = context.getBean("itemService", ItemService.class);
		System.out.println(service.getItems());
		
		System.out.println("======================");
		Item itema = context.getBean("itemA", Item.class);
		System.out.println(itema);
		System.out.println("======================");
		Item itemb = context.getBean("itemB", Item.class);
		System.out.println(itemb);
		System.out.println("======================");

		ClientService clientServive= context.getBean("clientService",ClientService.class);
		System.out.println(clientServive);

		ItemService serviceA =context.getBean("itemService",ItemService.class);
		System.out.println("service"+serviceA);
		
		ItemService serviceB =context.getBean("itemService",ItemService.class);
		System.out.println("service"+serviceB);
		
		context.close();
		
	}
}
