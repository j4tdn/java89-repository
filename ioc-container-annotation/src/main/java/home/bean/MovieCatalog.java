package home.bean;

import org.springframework.stereotype.Component;

@Component
public class MovieCatalog {

	private String catalog;

	public MovieCatalog(String catalog) {
		this.catalog = catalog;
	}

	public void showHotMovie() {
		switch (catalog) {
		case "Action":
			System.out.println("Hot>>Avatar>>Action");
			break;
		case "Adventure":
			System.out.println("Hot>>Avatar>>Adventure");
			break;
		default:
			break;
		}

	}
}
