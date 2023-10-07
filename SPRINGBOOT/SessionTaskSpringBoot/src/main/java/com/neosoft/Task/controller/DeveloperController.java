package com.neosoft.Task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Task.model.Developer;
import com.neosoft.Task.myException.ResourceNotFoundException;
import com.neosoft.Task.repository.DeveloperRepository;
import com.neosoft.Task.repository.ProjectRepository;

@RestController
//@RequestMapping("/developer")   //developer/add,developer/update
public class DeveloperController {
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	
	@GetMapping("/developer")
	public List<Developer> getAllDevelopers(){
		return developerRepository.findAll();
	}
	
	@PostMapping("/developer/project/{pId}/developers")
	public Developer createDeveloper(@PathVariable Long pId, @Valid @RequestBody Developer developer){
		return projectRepository.findById(pId).map(project -> {
			developer.setProject(project);
			return developerRepository.save(developer);
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", pId));
	}
	
	
	@GetMapping("/developer/{id}")
	public Developer getDeveloperById(@PathVariable long id) {
		return developerRepository.getById(id);
	}
	
	
	@PutMapping("/developer/projects/{pId}/developer/{id}")
	public Developer updateDeveloper(@PathVariable Long pId, @PathVariable Long id,
			 			@Valid @RequestBody Developer developerReq) {
		
		if(!projectRepository.existsById(pId))
			throw new ResourceNotFoundException("Project", "PId", pId);
		
		return developerRepository.findById(id).map(developer -> {
			developer.setName(developerReq.getName());
			developer.setEmail(developerReq.getEmail());
			return developerRepository.save(developer);
		}).orElseThrow(() -> new ResourceNotFoundException("Developer", "DeveloperId", id));
	}
	
	
	
	@DeleteMapping("/developer/{id}")
	public void deleteDeveloper(@PathVariable Long id) {
		
		developerRepository.findById(id).map(developer -> {
			developerRepository.delete(developer);
			return developer;
		}).orElseThrow(() -> new ResourceNotFoundException("Developer", "DeveloperId", id));
	}	
	
	
	

}
