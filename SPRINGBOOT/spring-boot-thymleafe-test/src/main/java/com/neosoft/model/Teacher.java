package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="teachers")
public class Teacher {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Tid")
	private Long id;
	
	@Column(name="Tf_Name",nullable = false)
	private String TfName;
	
	@Column(name="tL_Name")
	private String tLname;
	
	@Column(name="course")
	private String TCourse;
	
	@Column(name="tmobile")
	private String mobile;
	
	@Column(name="TE_Mail")
	private String TEmail;
	
	@Column(name="tcity")
	private String city;
	
	@Column(name="tstate")
	private String state;
	
	
	@Column(name="tpin")
	private String pincode;
	

}
