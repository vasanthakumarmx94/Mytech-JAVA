package com.neosoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(max=150)
	private String fullName;
	
	@Size(max = 100)
	private String email;
	
	@Size(max = 100)
	private String password;
	
	@Size(max=13)
	private String contactNo;
	
	@Size(max = 100)
	private String role;
	
	private int status;
	
	
	

}
