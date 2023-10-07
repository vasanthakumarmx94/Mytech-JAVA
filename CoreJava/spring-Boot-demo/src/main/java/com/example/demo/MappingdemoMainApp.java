package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Developer;
import com.example.demo.model.Project;
import com.example.demo.repository.DeveloperRepository;
import com.example.demo.repository.ProjectRepository;

@SpringBootApplication
public class MappingdemoMainApp implements CommandLineRunner{
//	@Autowired
//	private DeveloperRepository developerRepository;
//	
//	@Autowired
//	private ProjectRepository projectRepository;

	
	public static void main(String[] args) {
		//SpringApplication.run(MappingdemoMainApp.class, args);
	}

//	@Override
	public void run(String... args) throws Exception {
//
//		Developer developer=new Developer("preetham","preetham@gmail.com");
//		
//		
//		Project project=new Project("Mobile App",6);
//		
//		// set child reference in parent entity
//				developer.setProject(project);
//				
//				// set reference in child entity
//				project.setDeveloper(developer);
//				
//				//save parent reference also will save chilad ref as well
//				developerRepository.save(developer);
		
				
//				developerRepository.deleteById((long)2);
//				
				//developerRepository.de
//				Developer developer1 = developerRepository.findById((long)9).get();
//				project.setDeveloper(developer1);
//				projectRepository.save(project);
				
		
	}

}
