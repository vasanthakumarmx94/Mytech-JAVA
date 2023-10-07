package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	
	

}
