package home.service;

//join point bean
public class MovieService {
	private String name;
	private String catalog;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	//join Point methods
	public void printName() {
		System.out.println("movieservice >> printname"+name+".....");
	}
	public void printCatalog() {
		System.out.println("movieservice >> printcatalog"+name+".....");
	}
}
