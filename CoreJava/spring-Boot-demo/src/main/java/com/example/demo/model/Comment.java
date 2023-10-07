package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class Comment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Lob
	private String text;
	
	@ManyToOne
	@JoinColumn(name="post_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Post post;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//	public Post getPost() {
//		return post;
//	}
//
//	public void setPost(Post post) {
//		this.post = post;
//	}

	
	
}
