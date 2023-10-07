package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"age","userpass"})  // @JsonIgnoreProperties("age") // static level filter
@JsonFilter("UserBeanFilter")  // dynamic filter service level
public class UserFilterModel {

	
	private String username;
	
	//@JsonIgnore  // member level
	private String userpass;
	//@JsonIgnore  // member level
	private int age;
	
	
}
