package dto;

import java.time.LocalDateTime;

public class DeliveryConfirmedProductDTO {
	private Long orderId;
	private LocalDateTime orderTime;
	private Double totAmount;
	private String status;

	private Long productId;
	private String productName;
	private String productImage;
	private int quantity;

	private String address;

	public DeliveryConfirmedProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryConfirmedProductDTO(Long orderId, LocalDateTime orderTime, Double totAmount, String status,
			Long productId, String productName, String productImage, int quantity, String address) {
		super();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.totAmount = totAmount;
		this.status = status;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.quantity = quantity;
		this.address = address;
	}

	@Override
	public String toString() {
		return "DeliveryConfirmedProductDTO [orderId=" + orderId + ", orderTime=" + orderTime + ", totAmount="
				+ totAmount + ", status=" + status + ", productId=" + productId + ", productName=" + productName
				+ ", productImage=" + productImage + ", quantity=" + quantity + ", address=" + address + "]";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public Double getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(Double totAmount) {
		this.totAmount = totAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
