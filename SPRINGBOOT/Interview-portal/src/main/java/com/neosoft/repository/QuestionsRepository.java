package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>{

	
	
	
}
