package com.neosoft.Task.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.neosoft.Task.repository.MentorDTO;
import com.neosoft.Task.repository.NotNull;
import com.neosoft.Task.repository.Valid;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
    private String name;
    private String email;
    private LocalDate registerDate;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stream_id")
    Stream stream;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public Stream getStream() {
		return stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}
    
    

}


private Integer studentId;

@NotNull(message = "please provide name")
private String name;

@NotNull(message = "")
private String email;

@NotNull(message = "please provide registrationdate")
private LocalDate registerDate;

@NotNull(message = "please provide stream")
@Valid
private Stream stream;

