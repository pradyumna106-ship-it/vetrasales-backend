package com.sales.savvy.service;

import java.util.List;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;

public interface ProductService {
	void addProduct(ProductDTO prod);
	List<Product> searchProduct(String keyword);
	List<Product> getAllProducts();
	void updateProduct(ProductDTO prod);
	void deleteProduct(Long id);
}
