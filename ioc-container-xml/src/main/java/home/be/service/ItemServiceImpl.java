package home.be.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import home.be.bean.Item;

public class ItemServiceImpl implements ItemService{

	public List<Item> getItems() {
		return Arrays.asList(new Item(1,"itema"),new Item(2,"item2"));
	}
	
}
