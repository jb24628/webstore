package com.example.webstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductName {
	@Id
	Integer product;
	String productName;
	
	public ProductName() {
		super();
	}
	
	public ProductName(Integer product, String productName) {
		super();
		this.product = product;
		this.productName = productName;
	}
	
	public Integer getProduct() {
		return product;
	}
	public void setProduct(Integer product) {
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
