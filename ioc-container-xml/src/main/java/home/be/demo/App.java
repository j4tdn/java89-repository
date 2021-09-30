package home.be.demo;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import home.be.bean.Item;
import home.be.service.ClientService;
import home.be.service.ItemService;
import home.be.service.ItemServiceImp;

public class App {
	public static void main(String[] args) {

		// IoC container
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		// print beans in IoC container
		//	String[] beansName=context.getBeanDefinitionNames();
		//	Arrays.stream(beansName).forEach(System.out::println);

		ItemService service = context.getBean("itemService", ItemService.class);
		System.out.println(service.getItems());
		
		System.out.println("---------------------------------");

		Item item = context.getBean("itemA", Item.class);
		System.out.println(item);
		
		System.out.println("---------------------------------");

		ClientService clientService = context.getBean("clientService", ClientService.class);
		System.out.println(clientService);

		System.out.println("-----------------scope-------------");
		ItemService serviceA = context.getBean("itemService", ItemService.class);
		System.out.println(serviceA);

		ItemService serviceB = context.getBean("itemService", ItemService.class);
		System.out.println(serviceB);
		
		context.close();
	}

}
