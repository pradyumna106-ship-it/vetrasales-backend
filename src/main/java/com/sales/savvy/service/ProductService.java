package com.sales.savvy.service;

import java.util.List;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;

public interface ProductService {
	String addProduct(ProductDTO prod);
	ProductDTO searchProduct(Long id);
	List<Product> searchProduct(String keyword);
	List<Product> getAllProducts();
	String updateProduct(ProductDTO prod);
	void addReview(AddReviewDTO review);
	void deleteProduct(Long id);
}
