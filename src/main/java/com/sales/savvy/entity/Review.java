package com.sales.savvy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String reviewerName;
	    private String comment;
	    private int rating;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    @JsonBackReference
	    private Product product;

	    // No-arg constructor
	    public Review() {
	    }

	    // All-arg constructor
	    public Review(Long id, String reviewerName, String comment, int rating, Product product) {
	        this.id = id;
	        this.reviewerName = reviewerName;
	        this.comment = comment;
	        this.rating = rating;
	        this.product = product;
	    }

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
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

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }
}
