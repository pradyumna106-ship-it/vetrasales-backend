package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dto.CartData;
import dto.CartItemDTO;
import entity.Cart;
import entity.Product;
import entity.User;
import jakarta.transaction.Transactional;
import repository.CartItemRepository;
import repository.CartRepository;
import repository.ProductRepository;
import repository.UserRepository;
import entity.CartItem;

public class CartServiceImplementation {
	@Autowired private CartRepository cartRepo;
	@Autowired private CartItemRepository itemRepo;
	@Autowired private UserRepository userRepo;
	@Autowired private ProductRepository prodRepo;

	@Transactional
	public void addToCart(CartData data) {
		User user = userRepo.findByUsername(data.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		Cart cart = cartRepo.findByUser(user)
				.orElseGet(() -> {
					Cart c = new Cart(user);
					return cartRepo.save(c);
				});

		Product prod = prodRepo.findById(data.getProd().getId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		int qty = (data.getQuantity() != null ? data.getQuantity() : 1);
		Optional<CartItem> existing = 
				itemRepo.findByCartIdAndProdId(cart.getId(), prod.getId());

		CartItem item = existing
				.map(ci -> { ci.setQuantity(ci.getQuantity() + qty); return ci; })
				.orElseGet(() -> {
					CartItem ci = new CartItem(cart, prod, qty);
					return ci;
				});

		itemRepo.save(item);
	}

	@Transactional
	public void updateCartItem(CartData data) {
		User user = userRepo.findByUsername(data.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		Cart cart = cartRepo.findByUser(user)
				.orElseThrow(() -> new RuntimeException("Cart not found"));

		Long pid = data.getProd().getId();
		CartItem item = itemRepo.findByCartIdAndProdId(cart.getId(), pid)
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
		Optional<Cart> optCart = cartRepo.findByUser(user);
		if (optCart.isEmpty()) return new ArrayList<>();

		Cart cart = optCart.get();
		List<CartItemDTO> out = new ArrayList<>();
		for (CartItem ci : cart.getItemList()) {
			Product p = ci.getProd();
			out.add(new CartItemDTO(
					p.getId(), p.getName(), p.getDescription(),
					p.getPrice(), p.getImage(), ci.getQuantity()
					));
		}
		return out;
	}
}
