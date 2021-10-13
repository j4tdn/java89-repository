package home.be.bean;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Item implements InitializingBean, DisposableBean{
	private Integer id;
	private String name;
	private List<String> providers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getProviders() {
		return providers;
	}

	public void setProviders(List<String> providers) {
		this.providers = providers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "," + name +","+providers;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("item>>destroy...");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("item>>init...");
		
		// TODO Auto-generated method stub
		
	}
}
