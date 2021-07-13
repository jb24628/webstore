package com.example.webstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	Integer productID;
	Integer productType;
	Integer department;
	String imgSrc;
	
	public Product() {
		super();
	}
	
	public Product(Integer productID, Integer productType, Integer department, String imgSrc) {
		super();
		this.productID = productID;
		this.productType = productType;
		this.department = department;
		this.imgSrc = imgSrc;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
}
