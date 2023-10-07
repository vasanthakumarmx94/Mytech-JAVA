package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;
import com.example.model.Product;
import com.example.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	

	public void CreateProduct(ProductRequest productRequest) {
		
		Product product=new Product();
		        product.setId(productRequest.getId());
				product.setName(productRequest.getName());
				product.setDescription(productRequest.getDescription());
				product.setPrice(productRequest.getPrice());
				
		productRepository.save(product);
		log.info("Product {} is saved",product.getId());
		
	}



	public List<ProductResponse> getAllProdcts() {
		
		List<Product> products=productRepository.findAll();
		
		return products.stream().map(product->mapToProductResponse(product)).toList();
		
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		
		ProductResponse productResponse=new ProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setDescription(product.getDescription());
		productResponse.setPrice(product.getPrice());
		
		return productResponse;
		
	}
}
