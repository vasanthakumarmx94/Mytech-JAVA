package com.neosoft.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("application")
public class DbPropConfiguration {
	
	@Getter@Setter
	String driverclassname;
	@Getter@Setter
	String url;
	@Getter@Setter
	String username;
	@Getter@Setter
	String password;

	
}
