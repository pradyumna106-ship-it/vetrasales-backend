package com.sales.savvy.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired private ProductService service;
	
	 @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public String addProduct(@RequestBody ProductDTO prod) {
	        return service.addProduct(prod);
	}
	
	@GetMapping("/searchProductById")
	public ProductDTO searchProductById(@RequestParam Long productId) {
		return service.searchProduct(productId);
	}
	@GetMapping("/searchProduct")
	public List<ProductDTO> searchProduct(@RequestParam String keyword) {
		return service.searchProduct(keyword);
	}
	
	
	@GetMapping("/getAllProducts")
	public List<ProductDTO> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getByAdmin")
	public List<ProductDTO> getByAdmin(@RequestParam Long id) {
		return service.getByAdmin(id);
	}
	
	@PostMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody ProductDTO prodDto) {
	    
	    return service.updateProduct(prodDto);
	}

	@PostMapping("/addReview")
	public ResponseEntity<?> addReview(@RequestBody AddReviewDTO dto) {
	    System.out.println("CONTROLLER RECEIVED DTO: " + dto);
	    service.addReview(dto);
	    return ResponseEntity.ok("Review added");
	}



	@GetMapping("/deleteProduct")
	public void deleteProduct(@RequestParam Long productId) {
		service.deleteProduct(productId);
	}
}