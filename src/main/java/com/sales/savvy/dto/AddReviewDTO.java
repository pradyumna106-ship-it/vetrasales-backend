package com.sales.savvy.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AddReviewDTO {
	private Long productId;
	private int rating;
	private String comment;
	private String customerName;
	public AddReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddReviewDTO(Long productId, int rating, String comment, String customerName) {
		super();
		this.productId = productId;
		this.rating = rating;
		this.comment = comment;
		this.customerName = customerName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "AddReviewDTO [productId=" + productId + ", rating=" + rating + ", comment=" + comment
				+ ", customerName=" + customerName + "]";
	}
	
	
	
}
