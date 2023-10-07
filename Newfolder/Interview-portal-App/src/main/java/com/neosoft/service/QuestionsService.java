package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Company;
import com.neosoft.model.Experience;
import com.neosoft.model.Question;
import com.neosoft.repository.QuestionsRepository;

@Service
public class QuestionsService {

	
		@Autowired
		private QuestionsRepository questionsRepository;
		
		
		public Question saveQuestions(Question questions) {
			return questionsRepository.save(questions);
			
		}
		
		public Question getQuestionsById(long id) {
			return questionsRepository.getById(id);
			
		}
		
		public List<Question> getAllQuestions(){
			return questionsRepository.findAll();
			
		}
		
		public Question updateQuestions(Question question) {
			return questionsRepository.save(question);
			
		}
		public List<Question> getQuestionsByCompanyId(Company company){
			return questionsRepository.findByCompany( company);
			
		}
		public List<Question> getQuestionsByExperienceId(Experience experience){
			return questionsRepository.findByExperience( experience);
			
		}
		
		public List<Question> getQuestionsByCompanyExperience(Company company,Experience experience){
			return questionsRepository.findByCompanyAndExperience( company,experience);
			
		}
		
		
	
	
}
