package com.sales.savvy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

		public Review(Long id, String reviewerName, String comment, int rating, Product product) {
			super();
			this.id = id;
			this.reviewerName = reviewerName;
			this.comment = comment;
			this.rating = rating;
			this.product = product;
		}

		public Review() {
			super();
			// TODO Auto-generated constructor stub
		}

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

		@Override
		public String toString() {
			return "Review [id=" + id + ", reviewerName=" + reviewerName + ", comment=" + comment + ", rating=" + rating
					+ ", product=" + product + "]";
		}
	    
	    
}
