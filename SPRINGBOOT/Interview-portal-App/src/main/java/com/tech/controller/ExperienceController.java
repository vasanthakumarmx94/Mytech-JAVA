package com.tech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Experience;
import com.tech.myexception.ResourceNotFoundException;
import com.tech.repository.ExperienceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExperienceController {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExperienceRepository experienceRepository;

	// COMPANY APIs
	//http://localhost:8080/admin/save_company
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({"ROLE_ADMIN"}) 
	@PostMapping("/admin/save_experience")
	public void addExperience(@RequestBody Experience experience) {
		experienceRepository.save(experience);
		logger.info("/POST a Experience Logger method:"+new java.util.Date().toString());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllExperiences")
	public Object getAllExperiences() {
		logger.info("/GET a AllExperiences Logger method:"+new java.util.Date().toString());
		return experienceRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	@GetMapping("/experience/{id}")
	public ResponseEntity<Experience> getExperiencebyId(@PathVariable Long id) {
		Experience experience = experienceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Experience Not Found with id:" + id));;
		logger.info("/GET a Experience ByID:"+id+" Logger method:"+new java.util.Date().toString());
		return ResponseEntity.ok(experience);
	}

		// http://localhost:8080/admin/company/{id}
		@Secured({"ROLE_ADMIN"}) 
		@DeleteMapping("/admin/experience/{id}")
		public void harddeleteExperience(@PathVariable long id) {
			experienceRepository.deleteById(id);
			logger.info("/DELETE a Experience ByID:"+id+" Logger method:"+new java.util.Date().toString());
		}
}
