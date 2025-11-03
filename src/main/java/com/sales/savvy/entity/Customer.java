package com.sales.savvy.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@Column(unique = true)
	private String email;
	private String password;

	private String role;
	
	//cart Mapping
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Cart cart;
	
	//Order Mapping
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Orders> orders;
	
	
	@PrePersist
	public void setRole() {
		this.role = "customer";
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(Long id, String name, String email, String password, String role, Cart cart, List<Orders> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.cart = cart;
		this.orders = orders;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", cart=" + cart + ", orders=" + orders + "]";
	}

	
}
