package com.neosoft.model;

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
	private String role;
	
	private int status;
	
	@OneToOne
    @JoinColumn(name = "experience_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Experience experience;
	
	
}
