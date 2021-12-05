package home.configuaration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "home")
@Import(value = MovieConfiguration.class)
public class AppConfig {

}
