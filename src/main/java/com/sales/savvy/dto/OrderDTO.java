package com.sales.savvy.dto;

import java.util.List;

public class OrderDTO {
	 private Long id;
	 private String username;
	 private String status;
	 private String address;
	 private List<OrderItemDTO> items;
	 private double totalAmount;
	 public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	 }
	 public OrderDTO(Long id, String username, String status, String address, List<OrderItemDTO> items, double totalAmount) {
		super();
		this.id = id;
		this.username = username;
		this.status = status;
		this.address = address;
		this.items = items;
		this.totalAmount = totalAmount;
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
	 public String getStatus() {
		 return status;
	 }
	 public void setStatus(String status) {
		 this.status = status;
	 }
	 public String getAddress() {
		 return address;
	 }
	 public void setAddress(String address) {
		 this.address = address;
	 }
	 public List<OrderItemDTO> getItems() {
		 return items;
	 }
	 public void setItems(List<OrderItemDTO> items) {
		 this.items = items;
	 }
	 public double getTotalAmount() {
		 return totalAmount;
	 }
	 public void setTotalAmount(double totalAmount) {
		 this.totalAmount = totalAmount;
	 }
	 @Override
	 public String toString() {
		return "OrderDTO [id=" + id + ", username=" + username + ", status=" + status + ", address=" + address
				+ ", items=" + items + ", totalAmount=" + totalAmount + "]";
	 }
	 
	 
	 
}
