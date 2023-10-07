package com.example.demo.controler;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldcontroler {
	//http://localhost:8080/hello
	
		@GetMapping("/hello")
		public String hello() {
			return "Hello welcome to springboot demo API";
		}

		@GetMapping("/today")
		public String today() {
			return "Today:"+new Date().toString();
		}
	
}
