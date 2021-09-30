package home.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import home.bean.MovieCatalog;

@Configuration
public class MovieConfiguration {
	@Bean
	@Primary
	public MovieCatalog action() {
		return new MovieCatalog("Action");
	}

	@Bean
	public MovieCatalog adventure() {
		return new MovieCatalog("Adventure");
	}
}
