package home.be.bean;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Item implements InitializingBean, DisposableBean{
	private Integer id;
	private String name;
	private List<String> providers;
	
	public Item() {
		
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

	@Override
	public void destroy() throws Exception {
		System.out.println("Item >> Destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Item >> Init");
	}
}
