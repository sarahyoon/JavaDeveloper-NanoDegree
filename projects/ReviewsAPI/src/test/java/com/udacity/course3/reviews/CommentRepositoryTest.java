package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testFindComment(){

        //Create product
        Product product = new Product();
        product.setName("testProduct1");
        product.setInfo("info for product1");
        entityManager.persist(product);

        //Create Review
        Review review = new Review();
        review.setProductID(product.getProductID());
        review.setContent("review for product1");
        entityManager.persist(review);


        //Create Comment
        Comment comment = new Comment();
        comment.setReviewID(review.getReviewID());
        comment.setContent("comment for review");
        entityManager.persist(comment);

        List<Comment> realComment = commentRepository.findByReviewID(review.getReviewID());
        assertThat(realComment, is(notNullValue()));
        assertEquals(review.getReviewID(), realComment.get(0).getReviewID());

    }
}
