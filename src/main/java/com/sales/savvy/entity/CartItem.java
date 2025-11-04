package com.sales.savvy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product prod;

    private Integer quantity;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Long id, Cart cart, Product prod, Integer quantity) {
		super();
		this.id = id;
		this.cart = cart;
		this.prod = prod;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", prod=" + prod + ", quantity=" + quantity + "]";
	}
    
}
