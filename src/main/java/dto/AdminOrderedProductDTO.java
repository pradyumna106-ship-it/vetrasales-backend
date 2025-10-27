package dto;

import java.time.LocalDateTime;

public class AdminOrderedProductDTO {
	private String productName;
	private String productImage;
	private Double price;
	private int quantityOrdered;
	private Long orderId;
	private LocalDateTime orderDate;
	private String address; 

	public AdminOrderedProductDTO(String productName, String productImage, Double price, int quantityOrdered,
			Long orderId, LocalDateTime orderDate, String address) {
		this.productName = productName;
		this.productImage = productImage;
		this.price = price;
		this.quantityOrdered = quantityOrdered;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.address = address;
	}

	// Getters and Setters

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AdminOrderedProductDTO [productName=" + productName + ", productImage=" + productImage + ", price="
				+ price + ", quantityOrdered=" + quantityOrdered + ", orderId=" + orderId + ", orderDate=" + orderDate
				+ ", address=" + address + "]";
	}

}