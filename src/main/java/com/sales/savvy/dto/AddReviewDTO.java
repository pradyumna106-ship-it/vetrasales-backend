package com.sales.savvy.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AddReviewDTO {
	private Long id;
 	private Long productId;
    private String customerName;
    private String comment;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int rating;
	public AddReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddReviewDTO(Long id, Long productId, String customerName, String comment, String status,
			LocalDate date, int rating) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerName = customerName;
		this.comment = comment;
		this.status = status;
		this.date = date;
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "AddReviewDTO [id=" + id + ", productName=" + productId + ", customerName=" + customerName
				+ ", comment=" + comment + ", status=" + status + ", date=" + date + ", rating=" + rating + "]";
	}
	
	
}
