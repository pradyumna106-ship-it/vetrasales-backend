package com.sales.savvy.dto;


public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String category;
	private String image;
	private Boolean inStock;
	private String adminName;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(Long id, String name, String description, Double price, String image, String adminName, String category, Boolean inStock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.adminName = adminName;
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", adminName=" + adminName + "]";
	}
	
	
}
