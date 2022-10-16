package com.auth.model;

import java.util.Date;

import org.springframework.stereotype.Component;


public class Client {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Date birthday;
	private int phoneNumber;
	private String password;
	public Client(int id, String firstName, String lastName, String gender, String email,
			int phoneNumber,String password,Date birthday) {
		this.id = id;
this.birthday=birthday;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password=password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
