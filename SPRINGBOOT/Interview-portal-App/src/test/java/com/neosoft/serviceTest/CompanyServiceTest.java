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
import com.tech.repository.CompanyRepository;
import com.tech.service.CompanyService;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
	
	@Mock
    private CompanyRepository companyRepository ;
	
    @Autowired
    @InjectMocks
    private CompanyService companyService;
    
    private Company company1;
    private Company company2;
    List<Company> companyList;
    
    @BeforeEach
    public void setUp() {
    	companyList = new ArrayList<>();
    	company1 = new Company(1L,"Neosoft",1 );
    	company2 = new Company(2L,"Infosys",1);
    	companyList.add(company1);
    	companyList.add(company2);
    }
    
    @AfterEach
    public void tearDown() {
    	company1 = company2 = null;
    	companyList = null;
    }
    
    @Test
    void givenCompanyReturnAddedCompany() {
    	companyService.saveCompany(company1);
         verify(companyRepository,times(1)).save(company1);  
    }
	
    @Test
    public void GivenGetAllCompanyShouldReturnListOfAllCompany(){
    	companyRepository.save(company1);
        //stubbing mock to return specific data
        when(companyRepository.findAll()).thenReturn(companyList);
        List<Company> companyList1 =companyService.getAllCompany();
        assertEquals(companyList1,companyList);
        verify(companyRepository,times(1)).save(company1);
        verify(companyRepository,times(1)).findAll();
    }
    
    @Test
    public void givenIDThenShouldReturnCompanyOfThatID() {
    
    	   Mockito.when(companyRepository.findById((long) 1)).thenReturn(Optional.ofNullable(company1));
    	   assertThat(companyService.getCompanyByCompanyID(company1.getId())).isEqualTo(company1);
    }
    
    
    @Test
    public void givenIdTODeleteThenShouldDeleteTheCompany(){
    	companyService.deleteCompanyById(company1.getId());
    	assertThat(companyService.getCompanyByCompanyID(company1.getId())).isEqualTo(null);
    	
    }
    
    
    
    
    
    
	

}
