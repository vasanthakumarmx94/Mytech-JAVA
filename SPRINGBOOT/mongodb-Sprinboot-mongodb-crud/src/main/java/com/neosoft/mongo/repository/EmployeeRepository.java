package com.neosoft.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.mongo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

	
	
	
	
	
	
}
