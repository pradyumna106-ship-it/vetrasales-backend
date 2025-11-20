package com.sales.savvy.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sales.savvy.dto.OrderItemDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Order {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String username;          // Who placed the order
	    private String address;           // Delivery address
	    private String status;            // PAID, SHIPPED, DELIVERED
	    private double totalAmount;       // Total price

	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<OrderItem> orderItems;

		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Order(Long id, String username, String address, String status, double totalAmount,
				List<OrderItem> orderItems) {
			super();
			this.id = id;
			this.username = username;
			this.address = address;
			this.status = status;
			this.totalAmount = totalAmount;
			this.orderItems = orderItems;
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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> list) {
			this.orderItems = list;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", username=" + username + ", address=" + address + ", status=" + status
					+ ", totalAmount=" + totalAmount + "]";
		}

	    

}
