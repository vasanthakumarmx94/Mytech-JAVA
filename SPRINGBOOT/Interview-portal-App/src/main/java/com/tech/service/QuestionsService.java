package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.model.Company;
import com.tech.model.Experience;
import com.tech.model.Question;
import com.tech.repository.QuestionsRepository;

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
		
		public void DeleteQuestionsById(long id) {
			 questionsRepository.deleteById(id);	
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
