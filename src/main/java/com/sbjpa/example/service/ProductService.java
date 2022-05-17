package com.sbjpa.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbjpa.example.model.Product;
import com.sbjpa.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		Product prod=null;
		prod=productRepository.save(product);
		return prod;
	}
}
