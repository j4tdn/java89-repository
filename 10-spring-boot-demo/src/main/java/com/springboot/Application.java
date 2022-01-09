package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		/* Skip setup
		 * 1. WebApp Initializer
		 * 2. WebApp configure
		 * 3. WebServer such as Tomcat
		 */
		SpringApplication.run(Application.class, args);
	}

}
