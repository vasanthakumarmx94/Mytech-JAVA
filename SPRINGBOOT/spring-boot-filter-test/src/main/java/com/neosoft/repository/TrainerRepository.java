package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neosoft.model.Trainer;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>{

	
	
}
