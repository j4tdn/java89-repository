package home.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MovieRecomender {
	
	@Autowired
	@Qualifier(value = "action")
	private MovieCatalog movieCatalog;
}
