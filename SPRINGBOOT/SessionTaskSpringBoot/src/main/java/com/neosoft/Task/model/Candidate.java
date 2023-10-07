package com.neosoft.Task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@Entity
@Data
@Table(name="candidate")
@JsonFilter("CandidateBeanFilter")  // dynamic filter service level
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Cid;
	
	private String name;
	
	private int age;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pin;
	
	
	
	
}
