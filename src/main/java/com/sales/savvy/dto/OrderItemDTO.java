package com.sales.savvy.dto;

public class OrderItemDTO {
	private Long productId;
	private Integer quantity;

	public OrderItemDTO() {
	}

	public OrderItemDTO(Long productId,  Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;

	}

	@Override
	public String toString() {
		return "OrderItemDTO [productId=" + productId + ", quantity=" + quantity + "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
