package home.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import home.bean.MovieCatalog;

@Configuration
public class MovieConfig {
	@Bean
//	@Scope("prototype")
//	@Primary // kém ưu tiên hơn Qualifier
	public MovieCatalog action() {
		return new MovieCatalog("Action");
	}
	
	@Bean //đối tượng được tạo bời IoC container
	public MovieCatalog adventure() {
		return new MovieCatalog("Adventure");
	}
}
