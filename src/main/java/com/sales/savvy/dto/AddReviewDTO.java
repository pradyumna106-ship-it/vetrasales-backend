package com.sales.savvy.dto;

public class AddReviewDTO {
	private Long productId;
	private String reviewerName;
	private String comment;
	private int rating;

	public AddReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddReviewDTO(Long productId, String reviewerName, String comment, int rating) {
		super();
		this.productId = productId;
		this.reviewerName = reviewerName;
		this.comment = comment;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "AddReviewDTO [productId=" + productId + ", reviewerName=" + reviewerName + ", comment=" + comment
				+ ", rating=" + rating + "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
