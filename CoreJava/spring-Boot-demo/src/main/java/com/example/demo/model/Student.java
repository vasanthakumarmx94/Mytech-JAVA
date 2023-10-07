package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stid;
	
	@Column(name="stname",nullable = false)
	private String stname;
	
	@Column(name="stmarks",nullable = false)
	private int stmarks;
	
	@Column(name="subject",nullable = false)
	private String subject;
	
	Student(){
		
	}

	public Student(long stid, String stname, int stmarks, String subject) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.stmarks = stmarks;
		this.subject = subject;
	}

	public long getStid() {
		return stid;
	}

	public void setStid(long stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public int getStmarks() {
		return stmarks;
	}

	public void setStmarks(int stmarks) {
		this.stmarks = stmarks;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
		
}
