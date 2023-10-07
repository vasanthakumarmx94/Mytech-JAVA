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
import com.tech.repository.CompanyRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CompanyRepoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	// test methods for CRUD operations...
	
	@Test
	@Rollback
	public void testCreateCompany() throws ParseException { 
		Company savedCompany = companyRepository.save(new Company(2L, "Neosoft Group of company", 1));  
	    assertThat(savedCompany.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListCompany() {
	    List<Company> companys = (List<Company>) companyRepository.findAll();
	    assertThat(companys).size().isGreaterThan(0);
	}
	
	@Test
	public void TestUpdateCompany() throws ParseException {
		
		Company company=companyRepository.findById(2L).get();
		company.setCompanyName("Neosoft Group of company pvt ltd");
		company.setActive(1);
		Company savedCompany=companyRepository.save(company);
		Company existingCompany=entityManager.find(Company.class, savedCompany.getId());
		assertThat(company.getCompanyName()).isEqualTo(existingCompany.getCompanyName());
		
	}
	
	@Test
	public void testDeleteCompany() {
		Company company = companyRepository.findById(2L).get();
		companyRepository.deleteById(company.getId());
		Optional<Company> deletedCompany = companyRepository.findById(2L);
	    assertThat(deletedCompany.isPresent()).isFalse();       
	     
	}

	
	
}
