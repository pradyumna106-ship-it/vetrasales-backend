package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.sales.savvy.service.CartItemService;

@RestController
@RequestMapping("/api")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")

public class CartItemController {

    @Autowired
    private CartItemService service;

    @GetMapping("/removeItem")
    public String removeItem(@RequestParam("prod_id") Long prodId) {
        return service.removeItem(prodId);
    }
}


