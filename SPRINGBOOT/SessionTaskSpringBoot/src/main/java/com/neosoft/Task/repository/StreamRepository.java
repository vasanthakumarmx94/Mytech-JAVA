package com.neosoft.Task.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.Task.model.Stream;

public interface StreamRepository extends CrudRepository<Stream, Integer> {

	Optional<Stream> findByStraemName(String streamname);

	
	
}
