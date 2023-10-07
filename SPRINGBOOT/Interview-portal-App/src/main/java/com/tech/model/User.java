package com.tech.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	public User() {
		super();
	}

	public User(long id, @Size(max = 150) String firstName, @Size(max = 150) String lastName,
			@Size(max = 100) String email, @Size(max = 100) String password, @Size(max = 13) String contactNo,
			@Size(max = 100) String role, boolean status, Experience experience) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.role = role;
		this.status = status;
		this.experience = experience;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	
	@Size(max=150)
	private String firstName;
	
	@Size(max=150)
	private String lastName;
	
	@Size(max = 100)
	private String email;
	
	@Size(max = 100)
	private String password;
	
	@Size(max=13)
	private String contactNo;
	
	@Size(max = 100)
	private String role;	// ROLE_USER,ROLE_ADMIN
	
	private boolean status;	//	true/false
	
	@OneToOne
    @JoinColumn(name = "experience_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Experience experience;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	
}
