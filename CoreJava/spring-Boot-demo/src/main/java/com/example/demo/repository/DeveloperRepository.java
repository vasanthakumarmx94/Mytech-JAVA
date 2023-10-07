package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long>{

}
