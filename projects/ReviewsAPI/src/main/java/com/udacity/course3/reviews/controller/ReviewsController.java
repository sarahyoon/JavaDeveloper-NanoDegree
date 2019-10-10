package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewMongoRepository reviewMongoRepository;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review reviews) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            //save mysql
            reviews.setProductID(productId);
            reviews.setContent(reviews.getContent());
            reviewRepository.save(reviews);

            //save mongoDB
            List<Review> savedReview = reviewRepository.findByProductID(productId);
            for(Review r : savedReview){
                ReviewDocument reviewDocument = new ReviewDocument();
                reviewDocument.setReviewID(r.getReviewID());
                reviewDocument.setContent(r.getContent());
                reviewDocument.setProductID(r.getProductID());
                reviewMongoRepository.save(reviewDocument);
            }

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        List<Review> reviews = reviewRepository.findByProductID(productId);
        List<ReviewDocument> reviewDocuments = new ArrayList<>();
        for(Review r : reviews){
            ReviewDocument addReview = reviewMongoRepository.findByReviewID(r.getReviewID());
            reviewDocuments.add(addReview);
        }

        return new ResponseEntity<>(reviewDocuments, HttpStatus.OK);
    }
}