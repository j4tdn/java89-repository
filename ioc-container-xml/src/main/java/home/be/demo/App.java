package home.be.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import home.be.bean.Item;
import home.be.service.ClientService;
import home.be.service.ItemService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		ItemService itemService = context.getBean("itemService", ItemService.class);
		System.out.println(itemService.getItems());

//		System.out.println("================");
//
//		Item itemA = context.getBean("itemA", Item.class);
//		System.out.println(itemA);
//
//		System.out.println("================");
//
//		Item itemB = context.getBean("itemB", Item.class);
//		System.out.println(itemB);
//
//		System.out.println("================");
//		ClientService clientService = context.getBean("clientService", ClientService.class);
//		System.out.println(clientService);
		
		System.out.println("========SCOPE=========");
		ItemService itemServiceA = context.getBean("itemService", ItemService.class);
		System.out.println(itemServiceA);
		System.out.println(itemService);
		
		
	}
}
