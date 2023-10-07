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

import com.tech.model.Company;
import com.tech.model.Experience;
import com.tech.model.Question;
import com.tech.repository.CompanyRepository;
import com.tech.repository.ExperienceRepository;
import com.tech.repository.QuestionsRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class QuestionRepoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private QuestionsRepository questionsRepository;
	
	@Autowired
	private ExperienceRepository experienceRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	// test methods for CRUD operations...
	
	@Test
	@Rollback
	public void testCreateQuestion() throws ParseException { 
		
		Company savedCompany = companyRepository.save(new Company(2L, "Neosoft Group of company", 1));  
		Experience savedExperience = experienceRepository.save(new Experience(2L, "1-3years", 1)); 
		
		Question savedQuestion = questionsRepository.save(new Question(1L, "Definition","What is object?","Object is a instance of class","Test",savedCompany,savedExperience));  
	    assertThat(savedQuestion.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListQuestion() {
	    List<Question> questions = (List<Question>) questionsRepository.findAll();
	    assertThat(questions).size().isGreaterThan(0);
	}
	
	@Test
	public void TestUpdateQuestion() throws ParseException {
		
		Company savedCompany = companyRepository.save(new Company(2L, "Neosoft Group of company", 1));  
		Experience savedExperience = experienceRepository.save(new Experience(2L, "1-3years", 1)); 
		
		Question question = questionsRepository.save(new Question(1L, "Definition","What is object?","Object is a instance of class","Test",savedCompany,savedExperience));  
		question.setQuestionText("What is class?");
		question.setAnswerText("Class is template for object it's having member methods and fields.");
		
		
		Question savedQuestion=questionsRepository.save(question);
		Question existingQuestion=entityManager.find(Question.class, question.getId());
		assertThat(savedQuestion.getQuestionText()).isEqualTo(existingQuestion.getQuestionText());
		
	}
	
	@Test
	public void testDeleteQuestion() {
		Company savedCompany = companyRepository.save(new Company(2L, "Neosoft Group of company", 1));  
		Experience savedExperience = experienceRepository.save(new Experience(2L, "1-3years", 1)); 
		
		questionsRepository.save(new Question(1L, "Definition","What is object?","Object is a instance of class","Test",savedCompany,savedExperience));  
		
		
		Question question2 = questionsRepository.findById(1L).get();
		questionsRepository.deleteById(question2.getId());
		Optional<Question> deletedQuestion = questionsRepository.findById(1L);
	    assertThat(deletedQuestion.isPresent()).isFalse();       
	     
	    
	    
	}

	
	
	
	
}
