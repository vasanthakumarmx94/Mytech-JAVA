package com.neosoft.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class MongodbSprinbootMongodbCrudApplication extends SpringBootServletInitializer{

	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(MongodbSprinbootMongodbCrudApplication.class);  
	}  
	public static void main(String[] args) {
		SpringApplication.run(MongodbSprinbootMongodbCrudApplication.class, args);
	}

}
