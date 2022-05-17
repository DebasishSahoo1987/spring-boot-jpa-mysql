package com.sbjpa.example.model;

import java.io.Serializable;


public class UserInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private double salary;
	public UserInfo() {
		super();
	}
	public UserInfo(String userName, double salary) {
		super();
		this.userName = userName;
		this.salary = salary;
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
		return "UserInfo [userName=" + userName + ", salary=" + salary + "]";
	}
}
