package com.udacity.course3.reviews.mongoDBTest;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import org.hamcrest.Matchers;
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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CommentRepositoryTestMongo {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReviewMongoRepository mongoRepository;

    @Test
    public void testFindComment(){

        //create Review
        DBObject reviewObject = BasicDBObjectBuilder.start()
                .add("reviewID", 101)
                .add("content", "review test for product 1")
                .add("productID", 1).get();
        mongoTemplate.save(reviewObject, "reviews");

        //Create Comment
        Comment comment = new Comment();
        comment.setCommentID(1001);
        comment.setContent("comment test for review 101");
        comment.setReviewID((Integer) reviewObject.get("reviewID"));

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        //update reviewComment
        Criteria criteria = new Criteria("reviewID");
        criteria.is(101);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("comment", commentList);
        mongoTemplate.updateFirst(query, update, "reviews");

        ReviewDocument reviewDocument = mongoRepository.findByReviewID((Integer) reviewObject.get("reviewID"));
        assertThat(reviewDocument, is(Matchers.notNullValue()));
        assertEquals(reviewDocument.getComment().get(0).getCommentID(), comment.getCommentID());
    }

}
