package com.sales.savvy.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String productName;
	private String category;
	private String brand;
	private String description;
	private double price;
	private double discount;
	private double finalPrice;
	private int quantity;
	private double ratings;
	private String productImage;
	
	@ManyToOne
	@JoinColumn(name = "admin_id") 
	@JsonBackReference
	private Admin admin;
	
	@OneToMany(mappedBy = "product")
	@JsonManagedReference 
	private List<CartItem> item;
	
	@OneToMany(mappedBy = "product")
	@JsonManagedReference
	private List<OrderItem> items;
	
	@OneToMany(mappedBy = "product")
	@JsonManagedReference
	private List<Review> review;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String productName, String category, String brand, String description, double price,
			double discount, double finalPrice, int quantity, double ratings, String productImage, Admin admin,
			List<CartItem> item, List<OrderItem> items, List<Review> review) {
		super();
		Id = id;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.finalPrice = finalPrice;
		this.quantity = quantity;
		this.ratings = ratings;
		this.productImage = productImage;
		this.admin = admin;
		this.item = item;
		this.items = items;
		this.review = review;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<CartItem> getItem() {
		return item;
	}

	public void setItem(List<CartItem> item) {
		this.item = item;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", productName=" + productName + ", category=" + category + ", brand=" + brand
				+ ", description=" + description + ", price=" + price + ", discount=" + discount + ", finalPrice="
				+ finalPrice + ", quantity=" + quantity + ", ratings=" + ratings + ", productImage=" + productImage
				+ ", admin=" + admin + ", item=" + item + ", items=" + items + "]";
	}
	
	
}
