package home.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieRecomender {

	@Autowired
	private MovieCatalog movieCatalog;
	
	@Autowired
	public void showHotMovie() {
		movieCatalog.showHotMovie();
	}
}
