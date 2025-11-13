package com.sales.savvy.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired private ProductService service;
	
	@PostMapping(value = "/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody ProductDTO prod) {
		service.addProduct(prod);
		return "success";
	}
	
	@GetMapping(value = "/searchProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product searchProduct(Long id) {
		return service.searchProduct(id);
	}
	
	@GetMapping(value = "/getAllProducts", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PostMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
		String result = service.updateProduct(prod);
		
		if ("fail".equals(result)) {
            return ResponseEntity.status(409).body(" cant reach");
        } else {
            return ResponseEntity.ok("Updated successfully");
        }
	}
	
	@GetMapping(value = "/deleteProduct", consumes = {"application/json", "application/json;charset=UTF-8"})
	public void deleteProduct(Long id) {
		service.deleteProduct(id);
	}
}
