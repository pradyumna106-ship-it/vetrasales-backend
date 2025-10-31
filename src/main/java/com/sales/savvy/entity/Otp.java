package com.sales.savvy.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Otp {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String otp;

	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Otp(Long id, String email, String otp) {
		super();
		this.id = id;
		this.email = email;
		this.otp = otp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Otp [id=" + id + ", email=" + email + ", otp=" + otp + "]";
	}
}
