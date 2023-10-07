package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.model.RequestQuestion;

@Repository
public interface RequestQuestionRepository  extends JpaRepository<RequestQuestion, Long>{

	
	
	
	
}
