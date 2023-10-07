package com.example.demo.model;

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

@Entity
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

	// mapping 1-1
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dev_id")
	private Developer developer;

	public Project() {

	}

	public Project(@NotNull @Size(max = 65) String pName, @NotNull @Size(max = 65) int pduration) {
		super();
		this.pName = pName;
		this.pduration = pduration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPduration() {
		return pduration;
	}

	public void setPduration(int pduration) {
		this.pduration = pduration;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

}
