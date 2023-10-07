package com.neosoft.Task.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Data
@Table(name = "developer")
public class Developer {

	@Id
	@Column(name = "dev_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 65)
	private String Name;

	@NotNull
	@Size(max = 125)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="proj_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;

	
	
	
	
	
}
