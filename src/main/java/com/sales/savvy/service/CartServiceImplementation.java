package com.sales.savvy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.CartData;
import com.sales.savvy.dto.CartItemDTO;
import com.sales.savvy.entity.Cart;
import com.sales.savvy.entity.CartItem;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.User;
import com.sales.savvy.repository.CartItemRepository;
import com.sales.savvy.repository.CartRepository;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class CartServiceImplementation implements CartService {
	@Autowired private CartRepository repo;
	@Autowired private CartItemRepository itemRepo;
	@Autowired private UserRepository userRepo;
	@Autowired private ProductRepository prodRepo;
	@Transactional
	public void addToCart(CartData data) {
		User user = userRepo.findByUsername(data.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		Cart cart = repo.findByUser(user)
				.orElseGet(() -> {
					Cart c = new Cart();
					c.setUser(user);
					return repo.save(c);
				});

		Product prod = prodRepo.findById(data.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		int qty = (data.getQuantity() != null ? data.getQuantity() : 1);
		Optional<CartItem> existing = 
				itemRepo.findByCartIdAndProductId(cart.getId(), prod.getId());

		CartItem item = existing
				.map(ci -> { ci.setQuantity(ci.getQuantity() + qty); return ci; })
				.orElseGet(() -> {
					CartItem ci = new CartItem();
					ci.setCart(cart);
					ci.setProduct(prod);
					ci.setQuantity(qty);
					return ci;
				});

		itemRepo.save(item);
	}

	@Transactional
	public void updateCartItem(CartData data) {
		User user = userRepo.findByUsername(data.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		Cart cart = repo.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Cart not found"));

		Long pid = data.getProductId();
		CartItem item = itemRepo.findByCartIdAndProductId(cart.getId(), pid)
				.orElseThrow(() -> new RuntimeException("CartItem not found"));
		int newQty = data.getQuantity();
		if (newQty > 0) {
			item.setQuantity(newQty);
			itemRepo.save(item);
		} else {
			itemRepo.delete(item);
		}
	}

	@Transactional
	public List<CartItemDTO> getCartItems(String username) {

	    User user = userRepo.findByUsername(username)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    Optional<Cart> optCart = repo.findByUser(user);
	    if (optCart.isEmpty()) return new ArrayList<>();

	    Cart cart = optCart.get();
	    List<CartItemDTO> out = new ArrayList<>();

	    for (CartItem ci : cart.getItemList()) {
	        Product p = ci.getProduct();

	        out.add(new CartItemDTO(
	                p.getId(),
	                p.getName(),
	                p.getDescription(),
	                p.getPrice(),          // ✅ Double → Double
	                p.getImage(),
	                ci.getQuantity(),
	                p.getCategory()        // ✅ Enum
	        ));
	    }
	    return out;
	}



}
