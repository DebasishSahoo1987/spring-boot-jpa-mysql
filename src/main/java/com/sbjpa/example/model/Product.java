package com.sbjpa.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Product")
@IdClass(ProductNameCode.class)
public class Product {
	
	@Id
	private String name;
	
	@Id
	private int code;
	
	
	@Column
	private String price;

	public Product() {
		super();
	}

	public Product(String name, int code, String price) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + ", price=" + price + "]";
	}
	
	
	
	

}
