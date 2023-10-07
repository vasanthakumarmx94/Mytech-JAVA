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
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Task.model.Project;
import com.neosoft.Task.myException.ResourceNotFoundException;
import com.neosoft.Task.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	@PostMapping("/project")
	public Project createProject(@Valid @RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	
	@PutMapping("/projects/{pId}")
	public Project updatePost(@PathVariable Long pId, @Valid @RequestBody Project projectReq) {
		return projectRepository.findById(pId).map(project -> {
			project.setPName(projectReq.getPName());
			project.setPduration(projectReq.getPduration());
			return projectRepository.save(project);
		}).orElseThrow(() -> new ResourceNotFoundException("Project", "PId", pId));
	}
	
	
	@DeleteMapping("/project/{pId}")
	public Project deletepost(@PathVariable Long pId) {
		return projectRepository.findById(pId).map(project -> {
			projectRepository.delete(project);
			return project;
		}).orElseThrow(() -> new ResourceNotFoundException("Project", "PId", pId));

	}

}
