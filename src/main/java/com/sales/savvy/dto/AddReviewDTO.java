package com.sales.savvy.dto;



import com.fasterxml.jackson.annotation.JsonFormat;

public class AddReviewDTO {
	private Long productId;
	private int rating;
	private String comment;
	private String username;
	public AddReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddReviewDTO(Long productId, int rating, String comment, String username) {
		super();
		this.productId = productId;
		this.rating = rating;
		this.comment = comment;
		this.username = username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "AddReviewDTO [productId=" + productId + ", rating=" + rating + ", comment=" + comment
				+ ", username=" + username + "]";
	}
	
	
	
}
