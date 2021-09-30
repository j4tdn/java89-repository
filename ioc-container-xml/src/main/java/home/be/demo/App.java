package home.be.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import home.be.bean.Item;
import home.be.service.ClientService;
import home.be.service.ItemService;

public class App {
	public static void main(String[] args) {
		// IoC container  ApplicationContext
		 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		// print beans in context container
		// String[] beanNames = context.getBeanDefinitionNames();
		
		// Arrays.stream(beanNames).forEach(System.out::println);
		
		Item itemA = context.getBean("itemA", Item.class);
		System.out.println(itemA);

		System.out.println("======================");
		
		Item itemB = context.getBean("itemB", Item.class);
		System.out.println(itemB);

		System.out.println("======================");
		
		ItemService service = context.getBean("itemService", ItemService.class);
		System.out.println(service.getItems());
		
//		get ra theo id của bean ở file cấu hình .xml
		System.out.println("======================");
		ClientService clientService = context.getBean("clientService", ClientService.class);
		System.out.println(clientService);
		
		System.out.println("=======SCOPE========");
		System.out.println("--- singleton ---");
		ItemService serviceA = context.getBean("itemService", ItemService.class);
		System.out.println("serviceA: " + serviceA);
		
		ItemService serviceB = context.getBean("itemService", ItemService.class);
		System.out.println("serviceB: " + serviceB);
		
		// goi ham destroy trong Item
		context.close(); 
	}
}
