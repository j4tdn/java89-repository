package home.be.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import home.be.bean.Item;

public class ItemServiceImpl implements ItemService {

	@Override
	public List<Item> getItems() {

		return null;
	}

	@PostConstruct
	public void init() {
		System.out.println("ItemserviceImpl init");
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("ItemServiceImpl destroy");
	}
}
