package com.neosoft.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TempConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempConversionApplication.class, args);
	}

}
