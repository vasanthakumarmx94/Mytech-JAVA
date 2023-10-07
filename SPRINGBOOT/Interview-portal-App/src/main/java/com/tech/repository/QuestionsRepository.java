package com.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.model.Company;
import com.tech.model.Experience;
import com.tech.model.Question;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Long>{

	List<Question> findByCompany(Company company);
	
	List<Question> findByExperience(Experience experience);

	List<Question> findByCompanyAndExperience(Company company, Experience experience);
	
}
