package com.neosoft.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.myexception.ResourceNotFoundException;
import com.neosoft.model.Company;
import com.neosoft.repository.CompanyRepository;
import com.neosoft.service.CompanyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompanyController {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private CompanyRepository companyRepository;

	// COMPANY APIs
	//http://localhost:8080/admin/save_company
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/admin/save_company")
	public void registerCompany(@RequestBody Company company) {
		companyService.saveCompany(company);
		logger.info("/POST a Company Logger method:"+new java.util.Date().toString());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllcompanies")
	public Object getAllCompanies() {
		logger.info("/GET a AllCompany Logger method:"+new java.util.Date().toString());
		return companyRepository.findAll().stream().filter(el -> el.getActive() == 1);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getCompanybyId(@PathVariable Long id) {
		Company company = companyRepository.findById(id).filter(el -> el.getActive() == 1)
				.orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id:" + id));
		logger.info("/GET a Company ByID:"+id+" Logger method:"+new java.util.Date().toString());
		return ResponseEntity.ok(company);
	}

	// http://localhost:8080/admin/company/{id}
	@DeleteMapping("/admin/company/{id}")
	public void harddeleteCompany(@PathVariable long id) {
		companyRepository.deleteById(id);
		logger.info("/DELETE a Company ByID:"+id+" Logger method:"+new java.util.Date().toString());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("admin/company/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @Valid @RequestBody Company companyReq) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id:" + id));
		
		
		company.setCompanyName(companyReq.getCompanyName());
		company.setProfileDescription(companyReq.getProfileDescription());
		company.setEstablishDate(companyReq.getEstablishDate());
		company.setCompanyWebsite(companyReq.getCompanyWebsite());
		company.setJobDescription(companyReq.getJobDescription());
		company.setActive(companyReq.getActive());
		Company updatedCompany = companyRepository.save(company);
		logger.info("/UPDATE a Company ByID:"+id+" Logger method:"+new java.util.Date().toString());
		return ResponseEntity.ok(updatedCompany);
	}
	
	

}
