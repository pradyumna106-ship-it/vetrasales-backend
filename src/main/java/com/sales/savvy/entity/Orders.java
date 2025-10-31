package com.sales.savvy.entity;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String paymentId;
	private LocalDateTime ordertime;
	private Double totAmount;
	private String Address;
	private String status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customer customer;

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItem> items;

	@OneToOne(mappedBy = "order")
	@JsonManagedReference
	private Payment paymnet;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "delivery_person_id")
	private DeliveryPerson deliveryPerson;

	@PrePersist
	public void setStatus() {
		if (this.status == null || this.status.trim().isEmpty()) {
			this.status = "PENDING";
		}
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Long id, String paymentId, LocalDateTime ordertime, Double totAmount, String address, String status,
			Customer customer, List<OrderItem> items, Payment paymnet, DeliveryPerson deliveryPerson) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.ordertime = ordertime;
		this.totAmount = totAmount;
		Address = address;
		this.status = status;
		this.customer = customer;
		this.items = items;
		this.paymnet = paymnet;
		this.deliveryPerson = deliveryPerson;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", paymentId=" + paymentId + ", ordertime=" + ordertime + ", totAmount=" + totAmount
				+ ", Address=" + Address + ", status=" + status + ", customer=" + customer + ", items=" + items
				+ ", paymnet=" + paymnet + ", deliveryPerson=" + deliveryPerson + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDateTime getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(LocalDateTime ordertime) {
		this.ordertime = ordertime;
	}

	public Double getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(Double totAmount) {
		this.totAmount = totAmount;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Payment getPaymnet() {
		return paymnet;
	}

	public void setPaymnet(Payment paymnet) {
		this.paymnet = paymnet;
	}

	public DeliveryPerson getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}
}
