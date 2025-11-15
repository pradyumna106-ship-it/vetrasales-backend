package com.sales.savvy.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class ProductController {
	@Autowired private ProductService service;
	
	 @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public String addProduct(@RequestBody ProductDTO prod) {
	        
	        return service.addProduct(prod);
	}
	
	@GetMapping("/searchProductById")
	public Product searchProduct(@RequestParam Long productId) {
		return service.searchProduct(productId);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PostMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody ProductDTO prodDto) {
	    service.updateProduct(prodDto);
	    return "success";
	}

	

	@GetMapping("/deleteProduct")
	public void deleteProduct(@RequestParam Long productId) {
		service.deleteProduct(productId);
	}
}