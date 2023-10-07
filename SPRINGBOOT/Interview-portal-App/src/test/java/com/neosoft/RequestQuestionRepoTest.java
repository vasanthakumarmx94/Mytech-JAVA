package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.tech.model.RequestQuestion;
import com.tech.model.User;
import com.tech.repository.RequestQuestionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RequestQuestionRepoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private RequestQuestionRepository requestQuestionRepository;
	
	
	@Rollback
	public void testCreateExperience() throws ParseException { 
		User user=new User();
		RequestQuestion savedRequestquestion = requestQuestionRepository.save(new RequestQuestion(2L,"Neosoft","1-2years", "What is anstraction?",1,user));  
	    assertThat(savedRequestquestion.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListExperience() {
		//User user=new User();
		//RequestQuestion savedRequestquestion = requestQuestionRepository.save(new RequestQuestion(2L,"Neosoft","1-2years", "What is anstraction?",1,user));  
	    
		List<RequestQuestion> requestQuestions = (List<RequestQuestion>) requestQuestionRepository.findAll();
	    assertThat(requestQuestions).size().isGreaterThan(0);
	}
	
	
	@Test
	public void testDeleteRequest() {
		
		RequestQuestion requestQuestion = requestQuestionRepository.findById(15L).get();
		requestQuestionRepository.deleteById(requestQuestion.getId());
		Optional<RequestQuestion> deletedRequestQurstion = requestQuestionRepository.findById(15L);
	    assertThat(deletedRequestQurstion.isPresent()).isFalse();       
	     
	}
	
	
	
	
	
	
	
}
