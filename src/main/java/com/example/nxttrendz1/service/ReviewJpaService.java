package com.example.nxttrendz1.service;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    public ReviewJpaRepository reviewJpaRepository;

    @Autowired
    public ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> reviewsList = reviewJpaRepository.findAll();
        ArrayList<Review> reviews = new ArrayList<>(reviewsList);
        return reviews;
    }

    @Override
    public Review addReview(Review review) {
        try {
            Product product = review.getProduct();
            int productId = product.getProductId();
            Product newProduct = productJpaRepository.findById(productId).get();
            review.setProduct(newProduct);
            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong productId");
        }
    }

    @Override
    public Review getReviewById(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review updatReview(int reviewId, Review review) {
        try {
            Review newReview = reviewJpaRepository.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                newReview.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() > 0) {
                newReview.setRating(review.getRating());
            }
            if (review.getProduct() != null) {
                Product product = review.getProduct();
                int productId = product.getProductId();
                Product newProduct = productJpaRepository.findById(productId).get();
                newReview.setProduct(newProduct);
            }
            reviewJpaRepository.save(newReview);
            return newReview;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            reviewJpaRepository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Product getReviewProduct(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            Product product = review.getProduct();
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}