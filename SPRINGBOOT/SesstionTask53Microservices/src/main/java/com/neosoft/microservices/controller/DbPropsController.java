package com.neosoft.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.config.DbPropConfiguration;
import com.neosoft.microservices.model.DbProps;

@RestController
public class DbPropsController {

	@Autowired
	private DbPropConfiguration dbconfiguration;
	
	// localhost/8080:/db_props
		@GetMapping("/db_props")
		public DbProps getdbprops() {
			return new DbProps(dbconfiguration.getDriverclassname(),dbconfiguration.getUrl(),dbconfiguration.getUsername(),dbconfiguration.getPassword());
		}
	
	
}
