package com.neosoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 65)
	private String firstname;
	@NotNull
	@Size(max = 65)
	private String surname;

	@NotNull
	@Size(max = 15)
	private String phoneNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;

	@Temporal(TemporalType.DATE)
	@Column(name = "joiningdate")
	private Date joiningdate;

	@NotNull
	private int age;

	@NotNull
	@Size(max = 65)
	private String userName;

	@NotNull
	@Size(max = 265)
	private String Address;

	@NotNull
	@Size(max = 10)
	private String pincode;

	@Column(name = "is_active")
	private int active;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void validatePhoneNumber() {
		if (this.phoneNo.length() != 10)
			throw new RuntimeException("Phone number should be 10 digits long");
		if (!this.phoneNo.matches("\\d+"))
			throw new RuntimeException("Phone number should contain only digits");
		if (this.phoneNo.startsWith("0"))
			throw new RuntimeException("Phone number should not start with 0");
		if (this.phoneNo.length() >= 13)
			throw new RuntimeException("Phone number should not greater than 13 digit");

	}

}
