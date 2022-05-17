package com.sbjpa.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbjpa.example.model.Product;
import com.sbjpa.example.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		Product prod=null;
		prod=productService.saveProduct(product);
		return prod;
	}
}
