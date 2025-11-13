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
	public String addProduct(ProductDTO proddto) {
		if (proddto.getAdminName() == null || proddto.getDescription() == null || proddto.getId() == null || proddto.getName() == null || proddto.getPrice() == null) {
			return "fail";
		}
		Optional<User> admin = userRepo.findByUsername(proddto.getAdminName());
		Product prod = new Product();
		prod.setAdmin(admin.get());
		prod.setDescription(proddto.getDescription());
		prod.setImage(proddto.getImage());
		prod.setName(proddto.getName());
		prod.setPrice(proddto.getPrice());
		repo.save(prod);
		return "success";
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
	public String updateProduct(Product prod) {
		if (prod.getAdmin() == null|| prod.getDescription() == null || prod.getId() == null || prod.getImage() == null || prod.getName() == null || prod.getPrice() == null) {
			return "fail";
		}
		repo.save(prod);
		return "success";
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
}
