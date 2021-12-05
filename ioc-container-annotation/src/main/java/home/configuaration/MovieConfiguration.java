package home.configuaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import home.bean.MovieCatalog;

@Configuration
public class MovieConfiguration {
	
	@Bean
	public MovieCatalog action() {
		return new MovieCatalog("Action");
	}
	
	@Bean
	public MovieCatalog adventure() {
		return new MovieCatalog("Adventure");
	}
}
