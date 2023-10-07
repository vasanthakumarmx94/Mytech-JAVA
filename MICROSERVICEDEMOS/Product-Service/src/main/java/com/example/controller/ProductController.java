package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String greetWelcome() {
		return "Welcome to micro service";
	}
	
	@PostMapping("/product")
	public void createProduct(@RequestBody ProductRequest productRequest) {
		
		productService.CreateProduct(productRequest);
	}
	
	@GetMapping("/getproducts")
	public List<ProductResponse> getAllProduct() {
		return productService.getAllProdcts();
	}
	
	@GetMapping("/welcome")
	public String getAllGreeting() {
		
		return "Welcome to micro services";
	}
	
	
	
	
	
}
