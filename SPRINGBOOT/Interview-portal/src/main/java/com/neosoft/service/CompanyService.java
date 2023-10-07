package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Company;
import com.neosoft.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
		
	}
	
	public Company getCompanyById(long id) {
		return companyRepository.getById(id);
		
	}
	
	public List<Company> getAllCompany(){
		return companyRepository.findAll();
		
	}
	public void deleteCompanyById(long id) {
		companyRepository.deleteById(id);
		
	}
	
	public Company updateCompany(Company company) {
		return companyRepository.save(company);
		
	}
	
	
	
}
