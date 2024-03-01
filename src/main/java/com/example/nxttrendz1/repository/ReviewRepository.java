package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.*;

import java.util.*;

public interface ReviewRepository {
    ArrayList<Review> getReviews();

    Review addReview(Review review);

    Review getReviewById(int reviewId);

    Review updatReview(int reviewId, Review review);

    void deleteReview(int reviewId);

    Product getReviewProduct(int reviewId);

}