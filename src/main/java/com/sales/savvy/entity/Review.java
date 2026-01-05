package com.sales.savvy.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sales.savvy.enums.ReviewStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Review {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
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
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonManagedReference
	    private User user;
		public Review() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Review(Long id, String productName,  String comment, ReviewStatus status, LocalDate date,
				int rating, Product product) {
			super();
			this.id = id;
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


		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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
			return "Review [id=" + id + ", comment="
					+ comment + ", status=" + status + ", date=" + date + ", rating=" + rating + ", product=" + product
					+ "]";
		}

		
	    
	    
}
