package com.sales.savvy.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.CartData;
import com.sales.savvy.dto.CartItemDTO;
import com.sales.savvy.service.CartService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CartController {

    @Autowired 
    private CartService service;

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

