package com.neosoft.Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.Task.model.Project;



public interface ProjectRepository extends JpaRepository<Project, Long>{

}
