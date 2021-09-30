package home.bean;

import org.springframework.stereotype.Component;

//@Component
public class MovieCatalog {

	private final String catalog;
	
	public MovieCatalog(String catalog) {
		this.catalog = catalog;
	}

	public void showHotMovie() {
		switch (catalog) {
		case "Action":
			System.out.println("action");
			break;
		default:
			break;
		}
	}

	
}
