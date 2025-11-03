package com.sales.savvy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.savvy.entity.Cart;
import com.sales.savvy.entity.CartItem;
import com.sales.savvy.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

    void deleteByCart_Customer_Id(Long customerId);

}
