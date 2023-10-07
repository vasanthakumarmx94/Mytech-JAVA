package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	
	//create 2 users for demo(Authentication)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// {noop} to your password in order for the DelegatingPasswordEncoder
		
		//with hard coded values
		/*
		 * auth.inMemoryAuthentication().withUser("user").password("{noop}user123").
		 * roles("USER")
		 * .and().withUser("admin").password("{noop}admin123").roles("USER","ADMIN");
		 */
		
		//with database level
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		
		
	}
	
	// authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/trainerfilter/course").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.GET,"/trainerfilter/coursefeesname").hasAnyRole("ADMIN")  // for all end point with post
		.and()
		.csrf().disable();
		
		
		
//		http.httpBasic()
//		.and()
//		.authorizeRequests()
//		.antMatchers(HttpMethod.GET,"/posts").hasAnyRole("ADMIN","USER")
//		.antMatchers(HttpMethod.POST,"/posts").hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.PUT,"/posts/**").hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE,"/posts/**").hasAnyRole("ADMIN")
//		.and()
//		.csrf().disable();	
		
		
		
	}
	
	
	
}
