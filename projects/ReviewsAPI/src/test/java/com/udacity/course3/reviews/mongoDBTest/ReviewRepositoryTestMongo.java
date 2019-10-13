package com.udacity.course3.reviews.mongoDBTest;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReviewRepositoryTestMongo {

    @Autowired
    private ReviewMongoRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void mongoDBTest(){


        Product product = new Product();
        product.setName("testProduct1");
        product.setInfo("info for product1");

        //Create Review
        Review review = new Review();
        review.setProduct(product);
        review.setReviewID(101);
        review.setContent("review for product1");

        ReviewDocument reviewDocument1 = new ReviewDocument(review);
        reviewRepository.save(reviewDocument1);

        List<ReviewDocument> realReview = reviewRepository.findByProductID(0);
        assertThat(realReview, is(notNullValue()));

        ReviewDocument reviewDocument = realReview.get(0);
        assertEquals(101, reviewDocument.getReviewID());
        System.out.println(mongoTemplate.findAll(DBObject.class, "reviews"));

        //update Review
        ReviewDocument reviewDocument2 = reviewRepository.findByReviewID(review.getReviewID());
        System.out.println(reviewDocument2.get_id());

        //comment
        Comment comment = new Comment();
        comment.setReview(review);
        comment.setContent("comment for review");

        Criteria criteria = new Criteria("reviewID");
        criteria.is(review.getReviewID());

        Query query = new Query(criteria);

        Update update = new Update();
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        update.set("comment", commentList);

        mongoTemplate.updateFirst(query, update, "reviews");

        //getReview comment
        System.out.println(reviewRepository.findByReviewID(review.getReviewID()).getComment().get(0).getContent());
        assertEquals(comment.getContent(), reviewRepository.findByReviewID(review.getReviewID()).getComment().get(0).getContent());
    }
}
