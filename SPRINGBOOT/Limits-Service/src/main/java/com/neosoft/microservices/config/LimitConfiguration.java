package com.neosoft.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("limits-service")
public class LimitConfiguration {
	@Getter@Setter
	private int minimum;
	
	@Getter@Setter
	private int maximum;
	
	
}


