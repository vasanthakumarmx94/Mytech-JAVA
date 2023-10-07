package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max=65)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Size(max=65)
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Size(max=125)
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Size(max=15)
	private String password;
	
	// mapping
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "users")
	private UsersProfile userprofile;

	public Users(@NotNull @Size(max = 65) String firstName, @NotNull @Size(max = 65) String lastName,
			@NotNull @Size(max = 125) String email, @NotNull @Size(max = 15) String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Users() {
		
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

	public UsersProfile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UsersProfile userprofile) {
		this.userprofile = userprofile;
	}
	
	
	
	
	
	
}
