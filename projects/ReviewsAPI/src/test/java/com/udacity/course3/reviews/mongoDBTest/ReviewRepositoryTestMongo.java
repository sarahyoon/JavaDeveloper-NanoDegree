package com.udacity.course3.reviews.mongoDBTest;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
        //Create Review
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("reviewID", 101)
                .add("content", "review test for product 1")
                .add("productID", 1).get();
        mongoTemplate.save(objectToSave, "reviews");

        ReviewDocument realReview = reviewRepository.findByReviewID(101);

        assertThat(realReview, is(notNullValue()));
        assertEquals(1, realReview.getProductID());
        System.out.println(mongoTemplate.findAll(DBObject.class, "reviews"));
    }
}
