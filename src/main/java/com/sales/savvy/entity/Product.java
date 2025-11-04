package com.sales.savvy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String brand;
	private String category;
	private String description;
	private Integer price;
	private String image;
	@ManyToOne
	@JoinColumn(name = "admin_id") 
	@JsonBackReference
	private User admin;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String name, String brand, String category, String description, Integer price, String image,
			User admin) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.price = price;
		this.image = image;
		this.admin = admin;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
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
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", description="
				+ description + ", price=" + price + ", image=" + image + ", admin=" + admin + "]";
	}
	
	
	
}
