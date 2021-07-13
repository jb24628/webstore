package com.example.webstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerOrder {
	@Id
	Integer orderNumber;
	Integer userID;
	Integer productID;
	
	public CustomerOrder () {
		super();
	}
	
	public CustomerOrder(Integer orderNumber, Integer userID, Integer productID) {
		super();
		this.orderNumber = orderNumber;
		this.userID = userID;
		this.productID = productID;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
}
