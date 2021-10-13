package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import home.aspect.MovieAspect;
import home.service.MovieService;
import home.service.MovieServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	// join point
	@Bean
	public MovieService movieService() {
		return new MovieServiceImpl();
	}

	// aspectj >> advisor
	@Bean
	public MovieAspect movieAspect() {
		return new MovieAspect();
	}
}
