package com.neosoft.mongo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employee")
public class Employee {

	@Transient
	public static final String SEQUENCE_NAME="users_sequence";
	//which means field marked with @transient is ignored by mapping framework
	// the field mapped  to any db column
	
	
	@Id
	private long id;
	
	@NotBlank
	@Size(max=100)
	private String firstName;
	
	@NotBlank
	@Size(max=100)
	private String lastName;
	
	@NotBlank
	@Size(max=100)
	@Indexed(unique = true)
	private String emailId;
	
	public Employee(){ }
	
	public Employee(String firstName, String lastName, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		
		return "Employee [id="+id+", First Name="+firstName+", lastName="+lastName+", emailId="+emailId+"]";
	}
	
	
}
