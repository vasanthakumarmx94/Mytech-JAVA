package com.neosoft.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

	//http://localhost:8080/hello
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello welcome to springboot api";
	}
	
	
}
