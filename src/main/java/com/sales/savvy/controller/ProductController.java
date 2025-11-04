package com.sales.savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {
	@Autowired private ProductService service;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductDTO prod) {
		service.addProduct(prod);
		return "success";
	}
	
	@GetMapping("/searchProduct")
	public List<Product> searchProduct(@RequestParam String keyword) {
		return service.searchProduct(keyword);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody ProductDTO prod) {
		service.updateProduct(prod);
		return "success";
	}
	
	@GetMapping("/deleteProduct")
	public void deleteProduct(Long id) {
		service.deleteProduct(id);
	}
}
