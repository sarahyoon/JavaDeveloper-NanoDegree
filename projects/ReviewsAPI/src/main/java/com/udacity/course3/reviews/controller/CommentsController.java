package com.udacity.course3.reviews.controller;


import com.mongodb.Mongo;
import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReviewMongoRepository reviewMongoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId, @RequestBody @Valid Comment comment) {
        Optional<Review> OptionalReview = reviewRepository.findById(reviewId);
        Review review;
        if(OptionalReview.isPresent()){
            //save mysql
            review = OptionalReview.get();
            comment.setReview(review);
            comment.setContent(comment.getContent());
            commentRepository.save(comment);

            //save comment to review mongo document
            ReviewDocument reviewDocument = reviewMongoRepository.findByReviewID(reviewId);
            Criteria criteria = new Criteria("_id");
            criteria.is(reviewDocument.get_id());

            Query query = new Query(criteria);
            mongoTemplate.remove(query, "reviews");

            ReviewDocument updatedDoc = new ReviewDocument(review);
            List<Comment> commentList = new ArrayList<>();
            commentList.add(comment);
            reviewDocument.setComment(commentList);
            reviewMongoRepository.save(updatedDoc);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Comment> savedComment = commentRepository.findByReview(review);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        System.out.println(optionalReview.get().getReviewID());
        if(!optionalReview.isPresent()){
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }
        return commentRepository.findByReview(optionalReview.get());
    }
}