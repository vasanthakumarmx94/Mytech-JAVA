package com.neosoft.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tech.model.Company;
import com.tech.model.Experience;
import com.tech.model.Question;
import com.tech.repository.QuestionsRepository;
import com.tech.service.QuestionsService;

@ExtendWith(MockitoExtension.class)
public class QuestionsServiceTest {
	
	@Mock
    private QuestionsRepository questionsRepository ;
	
    @Autowired
    @InjectMocks
    private QuestionsService questionsService;
    
    private Question question1;
    private Question question2;
    private Company company1;
    private Experience experience1;
    
    List<Question> questionList;
    
    @BeforeEach
    public void setUp() {
    	questionList = new ArrayList<>();
    	company1 = new Company(1L,"Neosoft",1 );
    	experience1=new Experience(1L,"1-3years",1);
    	
    	question1 = new Question(1L,"Defination","What is object?","Object is a instance of class.","Test",company1,experience1 );
    	question2 = new Question(2L,"Defination","What is inheritance?","Inherits the properties from base to derived class","Test",company1,experience1);
    	questionList.add(question1);
    	questionList.add(question2);
    }
    
    @AfterEach
    public void tearDown() {
    	question1 = question2 = null;
    	questionList = null;
    }
    
    @Test
    void givenAddedQuestion() {
    	questionsService.saveQuestions(question1);
         verify(questionsRepository,times(1)).save(question1);  
    }
    
    @Test
    public void GivenGetAllReturnListOfAllQuestions(){
    	questionsRepository.save(question1);
        //stubbing mock to return specific data
        when(questionsRepository.findAll()).thenReturn(questionList);
        List<Question> questionList1 =questionsService.getAllQuestions();
        assertEquals(questionList1,questionList);
        verify(questionsRepository,times(1)).save(question1);
        verify(questionsRepository,times(1)).findAll();
    }
    
    @Test
    public void givenIdGetQuestionById() {
    
    	   Mockito.when(questionsRepository.findById((long) 1)).thenReturn(Optional.ofNullable(question1));
    	   assertThat(questionsService.getQuestionsById(question1.getId())).isEqualTo(question1);
    }
    
    
    @Test
    public void givenIdTODeleteThenShouldDeleteTheQuestion(){
    	questionsService.DeleteQuestionsById(question1.getId());
    	assertThat(questionsService.getQuestionsById(question1.getId())).isEqualTo(null);
    	
    }
    
    
    

}
