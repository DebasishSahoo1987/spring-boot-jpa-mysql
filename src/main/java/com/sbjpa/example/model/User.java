package com.sbjpa.example.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user")

public class User {
	@Id
	@Column(name ="id")
	@GeneratedValue
	private int id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "salary")
	private double salary;
	
	

	public User() {
		super();
	}
	
	

	public User(int id, String userName, double salary) {
		super();
		this.id = id;
		this.userName = userName;
		this.salary = salary;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", salary=" + salary + "]";
	}

}
