package com.sales.savvy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerDeliveryOtp {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String otp;
    private Long orderId;

	public CustomerDeliveryOtp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDeliveryOtp(Long id, String otp, Long orderId) {
		super();
		this.id = id;
		this.otp = otp;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CustomerDeliveryOtp [id=" + id + ", otp=" + otp + ", orderId=" + orderId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
