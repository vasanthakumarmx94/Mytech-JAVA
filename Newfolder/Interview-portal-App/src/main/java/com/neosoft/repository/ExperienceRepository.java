package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Experience;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
	
	
	

}
