package home.be.service;

public class ClientService {
	private static ClientService clientService=new ClientService();
	
	public static ClientService createInstance() {
		return new ClientService();
	}


}
