package com.neosoft.Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.Task.model.Developer;



public interface DeveloperRepository extends JpaRepository<Developer, Long>{

}
