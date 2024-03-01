package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;
import com.example.nxttrendz1.service.*;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ReviewController {
    @Autowired
    private ReviewJpaService reviewService;

    @GetMapping("/products/reviews")
    public ArrayList<Review> getReviews() {
        return reviewService.getReviews();
    }

    @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getReviewById(@PathVariable("reviewId") int reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        return reviewService.updatReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/reviews/{reviewId}/product")
    public Product getReviewProduct(@PathVariable("reviewId") int reviewId) {
        return reviewService.getReviewProduct(reviewId);
    }
}