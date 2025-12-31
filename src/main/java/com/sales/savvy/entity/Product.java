package com.sales.savvy.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sales.savvy.enums.Category;

import jakarta.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Column(length = 1000)
    private String description;
	private Double price;
	@Enumerated(EnumType.STRING)
    private Category category;
	private String image;
	@Column(nullable = false)
	private Boolean inStock;
	@ManyToOne
    @JoinColumn(name = "admin_id") // FK column in Product table
	@JsonManagedReference
    private User admin;
	@OneToMany(mappedBy = "product")
	@JsonManagedReference
	private List<Review> reviews;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id, String name, String description, Double price, Category category, String image, Boolean inStock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.inStock = inStock;
}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", image="
				+ image + ", admin=" + admin + "]";
	}
	

	
}
