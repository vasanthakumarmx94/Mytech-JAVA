package com.neosoft.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbProps {

	
	String driverclassname;
	String url;
	String username;
	String password;
	
	
	
	
}
