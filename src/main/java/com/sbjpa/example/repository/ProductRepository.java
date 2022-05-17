package com.sbjpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbjpa.example.model.Product;
import com.sbjpa.example.model.ProductNameCode;

public interface ProductRepository extends JpaRepository<Product, ProductNameCode>{

}
