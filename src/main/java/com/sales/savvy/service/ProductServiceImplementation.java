package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.AddReviewDTO;
import dto.CreateProductDTO;
import dto.UpdateProductDTO;
import entity.Admin;
import entity.Product;
import entity.Review;
import repository.AdminRepository;
import repository.ProductRepository;
import repository.ReviewRepository;

@Service
public class ProductServiceImplementation 
			implements ProductService {
	@Autowired private ProductRepository repo;

	@Autowired private AdminRepository adrepo;

	@Autowired private ReviewRepository reviewRepo;

	@Override
	public void create(CreateProductDTO createDto) {
		Admin admin = adrepo.findById(createDto.getAdminId())
				.orElseThrow(() -> new RuntimeException("Admin not found with id: " + createDto.getAdminId()));

		Product p = new Product();
		p.setBrand(createDto.getBrand());
		p.setCategory(createDto.getCategory());
		p.setDescription(createDto.getDescription());
		p.setDiscount(createDto.getDiscount());
		p.setProductName(createDto.getProductName());
		p.setPrice(createDto.getPrice());
		p.setProductImage(createDto.getProductImage());
		
		double price = createDto.getPrice();
	    double discount = createDto.getDiscount();
	    double finalPrice = price - (price * discount / 100);
	    p.setFinalPrice(finalPrice);
	    
		p.setAdmin(admin);
		repo.save(p);
	}

	public void update(UpdateProductDTO updDto) {
		Product p = repo.findById(updDto.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + updDto.getProductId()));

		Admin admin = adrepo.findById(updDto.getAdminId())
				.orElseThrow(() -> new RuntimeException("Admin not found with id: " + updDto.getAdminId()));

		p.setBrand(updDto.getBrand());
		p.setCategory(updDto.getCategory());
		p.setDescription(updDto.getDescription());
		p.setDiscount(updDto.getDiscount());
		p.setProductName(updDto.getProductName());
		p.setPrice(updDto.getPrice());
		p.setProductImage(updDto.getProductImage());
		p.setAdmin(admin);

		repo.save(p); // This will update the existing record
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts(Long id) {

		return repo.findByAdminId(id);
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		List<Product> products = repo.searchProduct(keyword);
		return products;
	}

	// customer product controller
	@Override
	public List<Product> viewAllProduct() {
		return repo.findAll();
	}

	@Override
	public List<Product> getProductById(List<Long> id) {
		return repo.findAllById(id);
	}

	@Override
	public void addReview(AddReviewDTO review) {
		Optional<Product> prod = repo.findById(review.getProductId());
		if (prod.isPresent()) {
			Review reviews = new Review();
			reviews.setRating(review.getRating());
			reviews.setComment(review.getComment());
			reviews.setReviewerName(review.getReviewerName());
			reviews.setProduct(prod.get());
			reviewRepo.save(reviews);

		} else {
			throw new RuntimeException("Product with ID " + review.getProductId() + " not found.");
		}
	}

}