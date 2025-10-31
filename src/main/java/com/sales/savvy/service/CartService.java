package com.sales.savvy.service;
import java.util.List;

import dto.CartData;
import dto.CartItemDTO;
public interface CartService {
	void addToCart(CartData data);
	void updateCartItem(CartData data);
	List<CartItemDTO> getCartItems(String username);
}
