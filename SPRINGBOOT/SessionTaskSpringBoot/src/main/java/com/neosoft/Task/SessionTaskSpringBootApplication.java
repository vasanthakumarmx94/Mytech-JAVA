package com.neosoft.Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SessionTaskSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionTaskSpringBootApplication.class, args);
	}

}
