package home.be.bean;

import java.util.List;

public class Item {
	private Integer id;
	private String name;
	private List<String> providers;

	public Item() {
		super();
	}

	public Item(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getProviders() {
		return providers;
	}

	public void setProviders(List<String> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", providers=" + providers + "]";
	}

}
