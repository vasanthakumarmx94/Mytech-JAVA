package com.tech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestQuestion {
	
	
	
	public RequestQuestion(Long id, String companyName, String experiencelevel, String questionText, int status,
			User user) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.experiencelevel = experiencelevel;
		this.questionText = questionText;
		this.status = status;
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String companyName;
	
	private String experiencelevel;
	
	private String questionText;
	
	private int status;
	@ManyToOne
    @JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getExperiencelevel() {
		return experiencelevel;
	}
	public void setExperiencelevel(String experiencelevel) {
		this.experiencelevel = experiencelevel;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
