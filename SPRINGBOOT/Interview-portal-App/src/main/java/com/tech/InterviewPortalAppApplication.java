package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
//@ComponentScan(basePackages = {"com.neosoft.service.CompanyServices"})
@SpringBootApplication
public class InterviewPortalAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(InterviewPortalAppApplication.class, args);
	}
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(InterviewPortalAppApplication.class);
	    }

}
