package com.neosoft.ControllerTest;

import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.controller.CompanyController;
import com.tech.model.Company;
import com.tech.service.CompanyService;

import static org.hamcrest.Matchers.*;

//@SpringBootTest
@WebMvcTest(controllers = CompanyController.class)
//@AutoConfigureMockMvc
public class CompanyControllerTest {

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private CompanyService service;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;

	 @Test
	 @DisplayName("POST /admin/save_company")
	 //@Rollback(true)
	 @WithMockUser(username="admin",roles={"ROLE_ADMIN"})
	 void testCreateCompany()
	  throws Exception {
	  
	  // Setup our mocked service 
		 Company companyToPost = new Company(23L,"Neosoft",1); 
		 Company companyToReturn = new Company(23L,"Neosoft",1);
		 doReturn(companyToReturn).when(service).saveCompany(any());
	  
	  // Execute the POST request 
	  mockMvc.perform(MockMvcRequestBuilders
	  .post("/admin/save_company") .header("X-Foo", "admin")
	  .contentType(MediaType.APPLICATION_JSON)
	  .content(asJsonString(companyToPost))) .andExpect(status().isOk());
	  
	  }

	@Test
	@DisplayName("GET /company success")
	// @WithMockUser(username="admin",roles={"ROLE_ADMIN"})
	void testGetcompanySuccess() throws Exception {
		// Setup our mocked service
		Company company1 = new Company(1L, "Neosoft", 1);
		// when(service.getAllCompany());

		doReturn(Lists.newArrayList(company1)).when(service).getAllCompany();

		// Execute the GET request
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllcompanies")
				.with(SecurityMockMvcRequestPostProcessors.user("admin").roles("ADMIN", "USER"))
				)

				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].companyName").value("Neosoft"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].active").value(1));

	}

	@Test
	@DisplayName("GET /company/1")
	@WithMockUser(username = "admin", roles = { "ROLE_ADMIN" })
	void testGetCompanyById() throws Exception {
		// Setup our mocked service
		Company company = new Company(1L, "Neosoft", 1);
		doReturn(company).when(service).getCompanyById(1L);

		// Execute the GET request
		mockMvc.perform(

				get("/company/{id}", 1L))
				// Validate the response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))

				// Validate the returned fields
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.companyName", is("Neosoft")))
				.andExpect(jsonPath("$.active", is(1)));

	}

//	@Test
//	@WithMockUser(username="admin",roles={"USER","ADMIN"})
//	public void shouldAuthenticatedBeTrueWithRoleUser() throws Exception {
//	    then(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
//	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
