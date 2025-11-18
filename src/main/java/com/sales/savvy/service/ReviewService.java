package com.sales.savvy.service;

import java.util.List;

import com.sales.savvy.entity.Review;

public interface ReviewService {
	List<Review> listOfReview(Long productId);

	String avgReview(Long productId);
}
