package com.sales.savvy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.savvy.entity.Product;
import com.sales.savvy.entity.Review;
import com.sales.savvy.repository.ProductRepository;
import com.sales.savvy.repository.ReviewRepository;
@Service
public class ReviewServiceImplementation implements ReviewService {
	@Autowired private ReviewRepository repo;
	
	@Autowired private ProductRepository prodRepo;
	@Override
	public List<Review> listOfReview(Long productId) {
		// TODO Auto-generated method stub
		return repo.findByProduct_Id(productId);
	}

	@Override
	public String avgReview(Long productId) {
		// TODO Auto-generated method stub
		Optional<Product> prod = prodRepo.findById(productId);
		List<Review> reviews = repo.findByProduct_Id(productId);
			int length = reviews.size();
			double totRes = 0.0;
			for(int i = 0; i < length; i++) {
				double review = reviews.get(i).getRating();
				totRes = totRes+ review;
			}
			double avgRev = (double) totRes / length;
			avgRev = Math.round(avgRev * 10.0) / 10.0;
		return String.valueOf(avgRev);
	}

}
