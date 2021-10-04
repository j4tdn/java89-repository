package home.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //tương đương bean có name = movieRecomender
public class MovieRecomender {
	@Autowired
	@Qualifier(value = "adventure") //tên hàm ở MovieConfig.java
	private MovieCatalog movieCatalog;
	
	public void showHotMovie() {
		movieCatalog.showHotMovie();
	}
}
