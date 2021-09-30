package home.bean;

//@Component
public class MovieCatalog {
	
	private final String catalog;
	
	public MovieCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	public void showHotMovie() {
		switch (catalog) {
		case "Action":
			System.out.println("Action film");
			break;
			
		case "Adventure":
			System.out.println("Adventure film");
			break;
		}
	}
}
