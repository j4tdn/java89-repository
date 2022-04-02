package com.shopme.admin;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		File file = new File("user-photos");
		String userPhotosPath = file.getAbsolutePath();
		
		registry.addResourceHandler("/user-photos/**" )
			.addResourceLocations("file:/" + userPhotosPath + "/");
		
	}
	
}
