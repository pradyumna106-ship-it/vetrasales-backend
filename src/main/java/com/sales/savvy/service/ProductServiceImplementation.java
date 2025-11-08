package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.dto.ProductDTO;
import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.User;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.UserRepository;

@Service
public class ProductServiceImplementation 
			implements ProductService {
	@Autowired private ProductRepository repo;
	@Autowired private UserRepository userRepo;

	@Override
	public void addProduct(ProductDTO proddto) {
		Optional<User> admin = userRepo.findByUsername(proddto.getAdminName());
		Product prod = new Product();
		prod.setAdmin(admin.get());
		prod.setDescription(proddto.getDescription());
		prod.setImage(proddto.getImage());
		prod.setName(proddto.getName());
		prod.setPrice(proddto.getPrice());
		repo.save(prod);
	}

	@Override
	public Product searchProduct(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public void updateProduct(Product prod) {
		repo.save(prod);
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
}
