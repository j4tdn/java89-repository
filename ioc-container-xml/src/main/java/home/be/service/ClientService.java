package home.be.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClientService {
	private static ClientService clientService = new ClientService();

	public static ClientService createInstance() {
		return clientService;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("destroy");
	}
}
