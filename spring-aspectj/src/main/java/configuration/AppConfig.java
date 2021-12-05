package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import home.aspectj.MovieAspect;
import home.service.MovieService;
import home.service.MovieServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public MovieService movieService() {
		return new MovieServiceImpl();
	}
	
	// AspectJ >> Advisor
	@Bean
	public MovieAspect movieAspect() {
		return new MovieAspect();
	}
	
}
