package com.neosoft.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.myexception.ResourceNotFoundException;
import com.neosoft.model.Questions;
import com.neosoft.repository.QuestionsRepository;
import com.neosoft.service.QuestionsService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuestionsService questionsService;

	@Autowired
	private QuestionsRepository questionsRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/admin/save_Questions")
	public void saveQuestions(@RequestBody Questions questions) {
		questionsService.saveQuestions(questions);
		logger.info("/POST a Questions Logger method:"+new java.util.Date().toString());
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllQuestions")
	public Object getAllQuestions() {
		logger.info("/GET AllQuestions Logger method:"+new java.util.Date().toString());
		return questionsService.getAllQuestions();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/{id}")
	public ResponseEntity<Questions> getQuestionsbyId(@PathVariable Long id) {
		Questions questions = questionsService.getQuestionsById(id);
		logger.info("/GET Questions ById Logger method:"+new java.util.Date().toString());
		return ResponseEntity.ok(questions);
	}

	
	// http://localhost:8080/admin/company/{id}
	@DeleteMapping("/admin/questions/{id}")
	public void deleteQuestions(@PathVariable long id) {
		questionsRepository.deleteById(id);
		logger.info("/DELETE Questions ById:"+id+" Logger method:"+new java.util.Date().toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
