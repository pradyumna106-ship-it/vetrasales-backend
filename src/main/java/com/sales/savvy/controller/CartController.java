package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.sales.savvy.dto.CartData;
import com.sales.savvy.dto.CartItemDTO;
import com.sales.savvy.service.CartService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping(value = "/api",consumes = MediaType.ALL_VALUE)
public class CartController {
    @Autowired private CartService service;

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody CartData data) {
        service.addToCart(data);
        return "success";
    }

    @PostMapping("/updateCartItem")
    public String updateCartItem(@RequestBody CartData data) {
        service.updateCartItem(data);
        return "success";
    }

    @GetMapping("/viewCart")
    public List<CartItemDTO> viewCart(@RequestParam String username) {
        return service.getCartItems(username);
    }
}