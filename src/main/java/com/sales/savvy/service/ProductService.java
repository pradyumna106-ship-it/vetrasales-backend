package com.sales.savvy.service;

import java.util.List;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;

public interface ProductService {
	String addProduct(ProductDTO prod);
	Product searchProduct(Long id);
	List<Product> searchProduct(String keyword);
	List<Product> getAllProducts();
	String updateProduct(ProductDTO prod);
	void deleteProduct(Long id);
}
