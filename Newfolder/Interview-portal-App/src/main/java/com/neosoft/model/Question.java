package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long id;
	
	@Size(max = 100)
	private String questionType;
	
	@Size(max = 300)
	private String questionText;
	
	@Size(max = 700)
	private String answerText;
	
	@Size(max = 1000)
	private String description;
	
	
	@ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

	@ManyToOne
    @JoinColumn(name = "experience_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Experience experience;
	
	

}
