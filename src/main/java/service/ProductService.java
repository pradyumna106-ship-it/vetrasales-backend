package service;

import java.util.List;

import dto.AddReviewDTO;
import dto.CreateProductDTO;
import dto.UpdateProductDTO;
import entity.Product;

public interface ProductService {

	void create(CreateProductDTO createDto);

	void update(UpdateProductDTO updDto);

	void delete(Long id);

	List<Product> getAllProducts(Long id);

	List<Product> searchProduct(String keyword);

	List<Product> viewAllProduct();

	List<Product> getProductById(List<Long> id);

	void addReview(AddReviewDTO review);
}
