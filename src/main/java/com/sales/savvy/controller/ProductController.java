package com.sales.savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.dto.CreateProductDTO;
import com.sales.savvy.dto.UpdateProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController
public class ProductController {
	@Autowired
	ProductService service;

	@PostMapping("/createProduct")
	public String create(@RequestBody CreateProductDTO createDto) {
		service.create(createDto);
		return "success";
	}

	@PostMapping("/updateProduct")
	public String update(@RequestBody UpdateProductDTO updDto) {
		System.out.println(updDto);
		service.update(updDto);
		return "updated";
	}

	@GetMapping("/deleteProduct")
	public void delete(Long id) {
		service.delete(id);
	}

	// admin products
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(Long id) {
		return service.getAllProducts(id);
	}

	@GetMapping("/searchProduct")
	public List<Product> searchProduct(@RequestParam String keyword) {
		System.out.println("Keyword received: " + keyword);
		return service.searchProduct(keyword);
	}

	// customer products
	@GetMapping("/viewAllProducts")	
	public List<Product> viewAllProduct() {
		return service.viewAllProduct();
	}

	@GetMapping("/getProductById")
	public List<Product> getProductById(@RequestParam List<Long> id) {
		return service.getProductById(id);
	}
	
	@PostMapping("/addReview")
	public void addReview(@RequestBody AddReviewDTO review) {
		 service.addReview(review);
	}
}