package com.neosoft.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.config.LimitConfiguration;
import com.neosoft.microservices.model.Limits;

@RestController
public class LimitsController {

	@Autowired
	private LimitConfiguration configuration;
	
	// localhost/8080:/limits
	@GetMapping("/limits")
	public Limits getlimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
	
	
}
