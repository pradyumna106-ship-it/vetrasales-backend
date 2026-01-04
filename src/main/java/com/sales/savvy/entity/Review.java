package com.sales.savvy.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sales.savvy.enums.ReviewStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Review {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String comment;
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private ReviewStatus status;
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Column(nullable = false)
	    private LocalDate date;
	    private Integer rating;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    @JsonBackReference
	    private Product product;

		public Review() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Review(Long id, String productName, String username, String comment, ReviewStatus status, LocalDate date,
				int rating, Product product) {
			super();
			this.id = id;
			this.username = username;
			this.comment = comment;
			this.status = status;
			this.date = date;
			this.rating = rating;
			this.product = product;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}


		public ReviewStatus getStatus() {
			return status;
		}

		public void setStatus(ReviewStatus status) {
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

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public String toString() {
			return "Review [id=" + id + ", username=" + username + ", comment="
					+ comment + ", status=" + status + ", date=" + date + ", rating=" + rating + ", product=" + product
					+ "]";
		}

		
	    
	    
}
