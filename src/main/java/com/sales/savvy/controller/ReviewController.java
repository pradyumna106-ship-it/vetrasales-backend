package com.sales.savvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.savvy.entity.Review;
import com.sales.savvy.service.ReviewService;
@CrossOrigin("*")
@RestController
@RequestMapping
public class ReviewController {
	@Autowired private ReviewService service;
	
	@GetMapping("/listOfReview")
	public List<Review> getReviews(@RequestParam("productId") Long productId) {
		return service.listOfReview(productId);
	}
	@GetMapping("/deleteReviewByProduct")
	public String deleteReviewByProduct(@RequestParam("productId") Long productId) {
		return service.deleteReviewByProductId(productId);
	}
	
}
