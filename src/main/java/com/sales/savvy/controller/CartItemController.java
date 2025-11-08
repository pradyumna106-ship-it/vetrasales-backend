package com.sales.savvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sales.savvy.service.CartItemService;

@CrossOrigin("*")
@RestController
@RequestMapping
public class CartItemController {

    @Autowired
    private CartItemService service;

    @GetMapping("/removeItem")
    public String removeItem(@RequestParam("prod_id") Long prodId) {
        return service.removeItem(prodId);
    }
}
