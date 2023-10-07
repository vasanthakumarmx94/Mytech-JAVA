package com.neosoft.Task.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	//create 2 users for demo(Authentication)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// {noop} to your password in order for the DelegatingPasswordEncoder
		auth.inMemoryAuthentication().withUser("user").password("{noop}user123").roles("USER")
		.and().withUser("admin").password("{noop}admin123").roles("USER","ADMIN");
		
		
	}
	
	// authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/developer").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.GET,"/developer/**").hasAnyRole("ADMIN","USER")
		//.antMatchers(HttpMethod.POST,"/posts").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/developer/**").hasAnyRole("ADMIN")  // for all end point with post
		.antMatchers(HttpMethod.PUT,"/developer/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/developer/**").hasAnyRole("ADMIN")
		.and()
		.csrf().disable();
		
	
		
	}
	
	
	
}
