package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Questions;
import com.neosoft.repository.QuestionsRepository;

@Service
public class QuestionsService {

	
		@Autowired
		private QuestionsRepository questionsRepository;
		
		
		public Questions saveQuestions(Questions questions) {
			return questionsRepository.save(questions);
			
		}
		
		public Questions getQuestionsById(long id) {
			return questionsRepository.getById(id);
			
		}
		
		public List<Questions> getAllQuestions(){
			return questionsRepository.findAll();
			
		}
		
		public Questions updateQuestions(Questions questions) {
			return questionsRepository.save(questions);
			
		}
		
		
		
		
	
	
}
