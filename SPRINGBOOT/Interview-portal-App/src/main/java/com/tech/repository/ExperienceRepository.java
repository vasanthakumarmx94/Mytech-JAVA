package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.model.Experience;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
	
	
	

}
