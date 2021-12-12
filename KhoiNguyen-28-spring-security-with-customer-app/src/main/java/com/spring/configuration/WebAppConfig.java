package com.spring.configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("com.spring")
@PropertySource("classpath:persistence.properties")
@EnableWebMvc
@EnableTransactionManagement
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	private final Logger LOG = Logger.getLogger(getClass().getName());

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
	}

	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		return viewResolver();
	}

	@Bean
	public DataSource dataSource() {
		// create connection pool
		ComboPooledDataSource DataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			DataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// set database connection props
		DataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		DataSource.setUser(env.getProperty("jdbc.user"));
		DataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool props
		DataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		DataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		DataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		DataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return DataSource;
	}

	private int getIntProperty(String prop) {
		return Integer.parseInt(env.getProperty(prop));
	}
	
}
