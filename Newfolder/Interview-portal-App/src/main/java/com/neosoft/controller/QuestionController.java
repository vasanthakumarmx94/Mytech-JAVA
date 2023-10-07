package com.neosoft.controller;

import java.util.List;

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

import com.neosoft.model.Company;
import com.neosoft.model.Experience;
import com.neosoft.model.Question;
import com.neosoft.repository.CompanyRepository;
import com.neosoft.repository.ExperienceRepository;
import com.neosoft.repository.QuestionsRepository;
import com.neosoft.service.QuestionsService;

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
	@PostMapping("/admin/save_Questions")
	public void saveQuestions(@RequestBody Question questions) {
		questionsService.saveQuestions(questions);
		logger.info("/POST a Questions Logger method:" + new java.util.Date().toString());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllQuestions")
	public Object getAllQuestions() {
		logger.info("/GET AllQuestions Logger method:" + new java.util.Date().toString());
		return questionsService.getAllQuestions();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/{id}")
	public ResponseEntity<Question> getQuestionsbyId(@PathVariable Long id) {
		Question questions = questionsService.getQuestionsById(id);
		logger.info("/GET Questions ById Logger method:" + new java.util.Date().toString());
		return ResponseEntity.ok(questions);
	}

	// http://localhost:8080/admin/company/{id}
	@DeleteMapping("/admin/questions/{id}")
	public void deleteQuestions(@PathVariable long id) {
		questionsRepository.deleteById(id);
		logger.info("/DELETE Questions ById:" + id + " Logger method:" + new java.util.Date().toString());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/company/{id}")
	public ResponseEntity<List<Question>> getQuestionsByCompanyId(@PathVariable Long id) {
		
		Company company=companyRepository.findById(id).get();
		List<Question> questions = questionsService.getQuestionsByCompanyId(company);
		logger.info("/GET Questions ById Logger method:" + new java.util.Date().toString());
		return  ResponseEntity.ok(questions);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/experience/{id}")
	public ResponseEntity<List<Question>> getQuestionsByExperienceId(@PathVariable Long id) {
		
		Experience experience=experienceRepository.findById(id).get();
		List<Question> questions = questionsService.getQuestionsByExperienceId(experience);
		logger.info("/GET Questions ById Logger method:" + new java.util.Date().toString());
		return  ResponseEntity.ok(questions);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions/company/experience/{cid}/{Eid}")
	public ResponseEntity<List<Question>> getQuestionsByCompanyExperience(@PathVariable Long cid, @PathVariable Long Eid) {
		
		Company company=companyRepository.findById(cid).get();
		Experience experience=experienceRepository.findById(Eid).get();
		
		List<Question> questions = questionsService.getQuestionsByCompanyExperience(company,experience);
		logger.info("/GET Questions ById Logger method:" + new java.util.Date().toString());
		return  ResponseEntity.ok(questions);
	}
	
	
	
	
}
