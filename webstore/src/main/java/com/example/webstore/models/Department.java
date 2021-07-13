package com.example.webstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	Integer departmentID;
	String name;
	
	public Department() {
		super();
	}
	
	public Department(Integer departmentID, String name) {
		super();
		this.departmentID = departmentID;
		this.name = name;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
