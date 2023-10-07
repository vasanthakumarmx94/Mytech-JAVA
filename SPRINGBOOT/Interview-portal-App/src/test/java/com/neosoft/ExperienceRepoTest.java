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

import com.tech.model.Experience;
import com.tech.repository.ExperienceRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ExperienceRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ExperienceRepository experienceRepository;
	
	// test methods for CRUD operations...
	
	
	@Test
	@Rollback
	public void testCreateExperience() throws ParseException { 
		Experience savedExperience = experienceRepository.save(new Experience(2L, "1-3years", 1));  
	    assertThat(savedExperience.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListExperience() {
	    List<Experience> experiences = (List<Experience>) experienceRepository.findAll();
	    assertThat(experiences).size().isGreaterThan(0);
	}
	
	@Test
	public void TestUpdateExperience() throws ParseException {
		
		Experience experience=experienceRepository.findById(2L).get();
		experience.setExperienceLevel("2-4years");
		experience.setActive(1);
		Experience savedExperience=experienceRepository.save(experience);
		Experience existingExperience=entityManager.find(Experience.class, savedExperience.getId());
		assertThat(experience.getExperienceLevel()).isEqualTo(existingExperience.getExperienceLevel());
		
	}
	
	@Test
	public void testDeleteExperience() {
		Experience experience = experienceRepository.findById(2L).get();
		experienceRepository.deleteById(experience.getId());
		Optional<Experience> deletedExperience = experienceRepository.findById(2L);
	    assertThat(deletedExperience.isPresent()).isFalse();       
	     
	}

	
	
	

}
