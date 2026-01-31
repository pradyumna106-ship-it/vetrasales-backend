package com.sales.savvy.service;

import java.util.List;
import java.util.UUID;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.Review;

public interface ProductService {
	String addProduct(ProductDTO prod);
	ProductDTO searchProduct(Long id);
	List<ProductDTO> searchProduct(String keyword);
	List<ProductDTO> getAllProducts();
	List<ProductDTO> getByAdmin(UUID id);
	String updateProduct(ProductDTO prod);
	Review addReview(AddReviewDTO review);
	void deleteProduct(Long id);
}
