package home.service;

/**
 * Join Point bean
 */
public class MovieService {
	private String name;
	private String catalog;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	// Join Point methods
	public void printName() {
		System.out.println("Movie Service >> printName " + name + "...");
	}
	
	public void printCatalog() {
		System.out.println("MovieService >> printCatalog " + catalog + "...");
	}
}
