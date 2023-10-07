package com.tech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Company;
import com.tech.myexception.ResourceNotFoundException;
import com.tech.repository.CompanyRepository;
import com.tech.service.CompanyService;

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
	@Secured({"ROLE_ADMIN"})
	public void registerCompany(@RequestBody Company company) {
		companyService.saveCompany(company);
		logger.info("/POST a Company Logger method:"+new java.util.Date().toString());
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllcompanies")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	//@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public Object getAllCompanies() {
		logger.info("/GET a AllCompany Logger method:"+new java.util.Date().toString());
		return companyRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/company/{id}")
	@Secured({ "ROLE_USER", "ROLE_ADMIN" }) 
	public ResponseEntity<Company> getCompanybyId(@PathVariable Long id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id:" + id));
		logger.info("/GET a Company ByID:"+id+" Logger method:"+new java.util.Date().toString());
		return ResponseEntity.ok(company);
	}

	// http://localhost:8080/admin/company/{id}
	@DeleteMapping("/admin/company/{id}")
	@Secured({"ROLE_ADMIN"})
	public void harddeleteCompany(@PathVariable long id) {
		companyRepository.deleteById(id);
		logger.info("/DELETE a Company ByID:"+id+" Logger method:"+new java.util.Date().toString());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/admin/update-company/{id}")
	@Secured({"ROLE_ADMIN"})
	public void updateCompany(@RequestBody Company companyReq, @PathVariable long id) {
		
		Company company = companyRepository.findById(id).get();
		company.setCompanyName(companyReq.getCompanyName());
		company.setActive(companyReq.getActive());
		
		companyService.saveCompany(company);
		logger.info("/PUT a Company Logger method:"+new java.util.Date().toString());
	}
	

}
