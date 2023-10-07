package com.neosoft.Task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "proj_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 65)
	@Column(name = "proj_name")
	private String pName;

	@NotNull
	@Column(name = "proj_duration")
	private int pduration;

//	// mapping 1-1
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "dev_id")
//	private Developer developer;

	
	
}
