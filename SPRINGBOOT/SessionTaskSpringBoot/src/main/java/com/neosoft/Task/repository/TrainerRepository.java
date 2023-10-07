package com.neosoft.Task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.Task.model.Trainer;



@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>{

	
	
}
