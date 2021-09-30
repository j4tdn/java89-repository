package home.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import home.bean.MovieCatalog;

//Similar to a crucial XML configuration file
@Configuration //~@Component, bên trong nhiều bean thì dùng @Configuration
@ComponentScan(basePackages = "home") //tìm các @Component trong phạm vi package home
@Import(value = MovieConfig.class)
public class AppConfig {

}
