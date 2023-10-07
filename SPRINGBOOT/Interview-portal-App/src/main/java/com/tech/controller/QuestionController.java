package com.tech.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Company;
import com.tech.model.Experience;
import com.tech.model.Question;
import com.tech.myexception.ResourceNotFoundException;
import com.tech.repository.CompanyRepository;
import com.tech.repository.ExperienceRepository;
import com.tech.repository.QuestionsRepository;
import com.tech.service.QuestionsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionsService questionsService;

	@Autowired
	private QuestionsRepository questionsRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ExperienceRepository experienceRepository;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({"ROLE_ADMIN" }) 
	@PostMapping("/admin/save_Questions")
	public void saveQuestions(@RequestBody Question questions) {
		questionsService.saveQuestions(questions);
		logger.info("/POST a Questions Logger method:" + new java.util.Date().toString());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	@GetMapping("/getAllQuestions")
	public Object getAllQuestions() {
		logger.info("/GET AllQuestions Logger method:" + new java.util.Date().toString());
		return questionsService.getAllQuestions();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/{id}")
	public ResponseEntity<Question> getQuestionsbyId(@PathVariable Long id) {
		Question question = questionsRepository.findById(id).get();
		logger.info("/GET Questions ById Logger method:" + new java.util.Date().toString());
		return ResponseEntity.ok(question);
	}
	
	
	// http://localhost:8080/admin/company/{id}
	@Secured({"ROLE_ADMIN" }) 
	@DeleteMapping("/admin/questions/{id}")
	public void deleteQuestions(@PathVariable long id) {
		questionsRepository.deleteById(id);
		logger.info("/DELETE Questions ById:" + id + " Logger method:" + new java.util.Date().toString());
	}

	
	@CrossOrigin(origins = "http://localhost:4200")
	@Secured({"ROLE_ADMIN" }) 
	@PutMapping("/admin/question/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @Valid @RequestBody Question questionReq) {
		Question question = questionsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id:" + id));
		
		question.setQuestionType(questionReq.getQuestionType());
		question.setQuestionText(questionReq.getQuestionText());
		question.setAnswerText(questionReq.getAnswerText());
		question.setDescription(questionReq.getDescription());
		question.setCompany(questionReq.getCompany());
		question.setExperience(questionReq.getExperience());
		
		//questionReq.setId(question.getId());
		
		Question updatedQuestion = questionsRepository.save(question);
		logger.info("/UPDATE a Company ByID:"+id+" Logger method:"+new java.util.Date().toString());
		return ResponseEntity.ok(updatedQuestion);
	}
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/company/{id}")
	public ResponseEntity<List<Question>> getQuestionsByCompanyId(@PathVariable Long id) {
		
		Company company=companyRepository.findById(id).get();
		List<Question> questions = questionsService.getQuestionsByCompanyId(company);
		logger.info("/GET Questions By CompanyId Logger method:" + new java.util.Date().toString());
		return  ResponseEntity.ok(questions);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/experience/{id}")
	public ResponseEntity<List<Question>> getQuestionsByExperienceId(@PathVariable Long id) {
		
		Experience experience=experienceRepository.findById(id).get();
		List<Question> questions = questionsService.getQuestionsByExperienceId(experience);
		logger.info("/GET Questions ExperienceById Logger method:" + new java.util.Date().toString());
		return  ResponseEntity.ok(questions);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/company/experience/{cid}/{Eid}")
	public ResponseEntity<List<Question>> getQuestionsByCompanyExperience(@PathVariable Long cid, @PathVariable Long Eid) {
		
		Company company=companyRepository.findById(cid).get();
		Experience experience=experienceRepository.findById(Eid).get();
		
		List<Question> questions = questionsService.getQuestionsByCompanyExperience(company,experience);
		logger.info("/GET Questions Company and experience ById Logger method:" + new java.util.Date().toString());
		return  ResponseEntity.ok(questions);
	}
	
	
	
	
}
