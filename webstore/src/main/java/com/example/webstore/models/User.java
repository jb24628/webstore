package com.example.webstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	String firstName;
	String secondName;
	@Id
	Integer ID;
	String username;
	String password;
	
	public User() {
		super();
	}
	
	public User(String firstName, String secondName, Integer iD, String username, String password) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		ID = iD;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
