package com.user;

public class Student {
	private String firstName;
	private String lastName;
	private String email;
	private String schoolName;
	private String password;
	private double gpa,bmi; 
	private Address address;
	private double  totalIncomeTax;
	private double taxPercent;
	public Student() {};
	
	public Student(String firstName, String lastName, String email, String schoolName, String password, double gpa,
			Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.schoolName = schoolName;
		this.password = password;
		this.gpa = gpa;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public String getPassword() {
		return password;
	}

	public double getGpa() {
		return gpa;
	}

	public Address getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getTotalIncomeTax() {
		return totalIncomeTax;
	}

	public void setTotalIncomeTax(double d) {
		this.totalIncomeTax = d;
	}

	public double getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(double d) {
		this.taxPercent = d;
	}
	
	
	
}
