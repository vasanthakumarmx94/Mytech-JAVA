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

import com.tech.model.RequestQuestion;
import com.tech.repository.RequestQuestionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RequestQuestionController {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RequestQuestionRepository requestQuestionRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({ "ROLE_USER"}) 
	@PostMapping("/user/saveRequestQuestion")
	public void saveRequestQuestion(@RequestBody RequestQuestion requestQuestion) {
		requestQuestionRepository.save(requestQuestion);
		logger.info("/POST a RequestQuestions Logger method:" + new java.util.Date().toString());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	@GetMapping("/getAllRequestQuestion")
	public Object getAllRequestQuestions() {
		logger.info("/GET AllRequestQuestions Logger method:" + new java.util.Date().toString());
		return requestQuestionRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	@GetMapping("/Requestquestion/{id}")
	public ResponseEntity<RequestQuestion> getRequestQuestionsbyId(@PathVariable Long id) {
		RequestQuestion Requestquestion = requestQuestionRepository.findById(id).get();
		logger.info("/GET Questions ById Logger method:" + new java.util.Date().toString());
		return ResponseEntity.ok(Requestquestion);
	}

	// http://localhost:8080/admin/company/{id}
	@DeleteMapping("/admin/requestquestions/{id}")
	@Secured({ "ROLE_ADMIN" }) 
	public void deleteRequestQuestions(@PathVariable long id) {
		requestQuestionRepository.deleteById(id);
		logger.info("/DELETE Questions ById:" + id + " Logger method:" + new java.util.Date().toString());
	}

	
	
}
