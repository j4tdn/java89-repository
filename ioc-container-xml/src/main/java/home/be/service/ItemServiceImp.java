package home.be.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import home.be.bean.Item;

public class ItemServiceImp implements ItemService{

	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return Collections.EMPTY_LIST;
	}
	@PostConstruct
	public void init() {
		System.out.println("client service initial>>");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("client service cleanup>>");
	}

}
