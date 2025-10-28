package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dto.CartData;
import dto.CartItemDTO;
import service.CartService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CartController {


	@Autowired private CartService service;

	@PostMapping(value = "/addToCart", consumes = "application/json", produces = "application/json")
	public String addtocart(@RequestBody CartData data) {
		service.addToCart(data);
		return "success";
	}

	@GetMapping("/viewCart")
	public List<CartItemDTO> viewCart(@RequestParam String email) {
		return service.getCartItems(email);
	}

	@PostMapping("/updateCartItem")
	public String updateCartItem(@RequestBody CartData data) {
		service.updateCartItem(data);
		return "success";
	}

}