package com.sales.savvy.dto;

import entity.Product;

public class CartData {
	String customerEmail;
	Product prod;
	Integer quantity;
	
	public CartData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartData(String customerEmail, Product prod, Integer quantity) {
		super();
		this.customerEmail = customerEmail;
		this.prod = prod;
		this.quantity = quantity;
	}

	public String getUsername() {
		return customerEmail;
	}
	public void setUsername(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartData [username=" + customerEmail + ", prod=" + prod + ", quantity=" + quantity + "]";
	}
	
	
}