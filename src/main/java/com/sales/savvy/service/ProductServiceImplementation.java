package com.sales.savvy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.AddReviewDTO;
import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.Review;
import com.sales.savvy.entity.User;
import com.sales.savvy.enums.Category;
import com.sales.savvy.enums.ReviewStatus;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.ReviewRepository;
import com.sales.savvy.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired private ProductRepository repo;
	@Autowired private UserRepository userRepo;
	@Autowired private ReviewRepository reviewRepo;

	@Override
	public String addProduct(ProductDTO proddto) {
		if (proddto.getAdminName() == null || proddto.getDescription() == null || proddto.getName() == null || proddto.getPrice() == null) {
			System.out.println(proddto);
			return proddto + " the reason.";
		}
		Optional<User> admin = userRepo.findByUsername(proddto.getAdminName());
		Product prod = new Product();
		prod.setAdmin(admin.get());
		prod.setDescription(proddto.getDescription());
		prod.setImage(proddto.getImage());
		prod.setName(proddto.getName());
		prod.setPrice(proddto.getPrice());
		prod.setCategory(Category.valueOf(proddto.getCategory().toUpperCase()));
		prod.setInStock(proddto.isInStock());
		repo.save(prod);
		return "success";
	}

	@Override
	public ProductDTO searchProduct(Long id) {
		Product prod = repo.findById(id).get();
		ProductDTO dto = new ProductDTO();
		dto.setAdminName(prod.getAdmin().getUsername());
		dto.setDescription(prod.getDescription());
		dto.setId(prod.getId());
		dto.setImage(prod.getImage());
		dto.setName(prod.getName());
		dto.setPrice(prod.getPrice());
		dto.setCategory(prod.getCategory().toString());
		return dto;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = repo.findAll();
		List<ProductDTO> productsDto = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			Product prod = products.get(i);
			ProductDTO proddto = new ProductDTO();
			proddto.setAdminName(prod.getAdmin().getUsername());
			proddto.setCategory(prod.getCategory().toString());
			proddto.setDescription(prod.getDescription());
			proddto.setId(prod.getId());
			proddto.setImage(prod.getImage());
			proddto.setInStock(prod.getInStock());
			proddto.setName(prod.getName());
			proddto.setPrice(prod.getPrice());
			productsDto.add(proddto);
		}
		return productsDto;
	}

	@Override
	public String updateProduct(ProductDTO prod) {
		if (prod.getDescription() == null || prod.getId() == null || prod.getImage() == null || prod.getName() == null || prod.getPrice() == null) {
			return  prod + "the reason is to get failed";
		}
		Optional<User> admin = userRepo.findByUsername(prod.getAdminName());
		Product product = new Product();
		product.setId(prod.getId());
		product.setName(prod.getName());
		product.setDescription(prod.getDescription());
		product.setCategory(Category.valueOf(prod.getCategory().toUpperCase()));
		product.setImage(prod.getImage());
		product.setPrice(prod.getPrice());
		product.setInStock(prod.isInStock());
		product.setAdmin(admin.get());
		repo.save(product);
		return "success";
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<ProductDTO> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		List<Product> products = repo.searchProduct(keyword);
		List<ProductDTO> productsDto = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			Product prod = products.get(i);
			ProductDTO proddto = new ProductDTO();
			proddto.setAdminName(prod.getAdmin().getUsername());
			proddto.setCategory(prod.getCategory().toString());
			proddto.setDescription(prod.getDescription());
			proddto.setId(prod.getId());
			proddto.setImage(prod.getImage());
			proddto.setInStock(prod.getInStock());
			proddto.setName(prod.getName());
			proddto.setPrice(prod.getPrice());
			productsDto.add(proddto);
		}
		return productsDto;
	}

	@Override
	@Transactional
	public void addReview(AddReviewDTO review) {
		// TODO Auto-generated method stub
		Optional<Product> prod = repo.findById(review.getProductId());
		if (prod.isPresent()) {
			Review reviews = new Review();
			reviews.setRating(review.getRating());
			reviews.setComment(review.getComment());
			reviews.setCustomerName(review.getCustomerName());;
			reviews.setProduct(prod.get());
			reviewRepo.save(reviews);

		} else {
			throw new RuntimeException("Product " + review.getProductId() + " not found.");
		}
	}

	@Override
	public List<ProductDTO> getByAdmin(Long id) {
		// TODO Auto-generated method stub
		List<Product> products = repo.findByAdminId(id);
		List<ProductDTO> productsDto = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			Product prod = products.get(i);
			ProductDTO proddto = new ProductDTO();
			proddto.setAdminName(prod.getAdmin().getUsername());
			proddto.setCategory(prod.getCategory().toString());
			proddto.setDescription(prod.getDescription());
			proddto.setId(prod.getId());
			proddto.setImage(prod.getImage());
			proddto.setInStock(prod.getInStock());
			proddto.setName(prod.getName());
			proddto.setPrice(prod.getPrice());
			productsDto.add(proddto);
		}
		return productsDto;
	}
}
