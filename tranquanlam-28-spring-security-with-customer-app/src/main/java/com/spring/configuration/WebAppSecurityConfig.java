package com.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.service.UserService;


@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private UserService userService;
	
//	@Autowired
//	private DataSource dataSource;
    
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Opt1: Use in memory database
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//				.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//				.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));

		// Opt2: Use predefined database tables from Spring Security
//		auth.jdbcAuthentication()
//			.dataSource(dataSource);
		
		// Opt3: Use custom database table
		auth.authenticationProvider(authenticationProvider());
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/resources/**")
				.permitAll()
			.antMatchers("/customer/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
//			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticate")
				.successHandler(customAuthenticationSuccessHandler)
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
	//bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
}
