package com.sbjpa.example.model;

import java.io.Serializable;
import java.util.Objects;

public class ProductNameCode implements Serializable {
	
	/*
	 * In order to define the composite primary keys, we should follow some rules:
	  
	 * The composite primary key class must be public. It must have a no-arg
	 * constructor. It must define the equals() and hashCode() methods. It must be
	 * Serializable.
	 */

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int code;
	
	public ProductNameCode() {
		super();
	}
	public ProductNameCode(String name, int code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "ProductNameCode [name=" + name + ", code=" + code + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductNameCode other = (ProductNameCode) obj;
		return code == other.code && Objects.equals(name, other.name);
	}
	
	
	
	
	

}
