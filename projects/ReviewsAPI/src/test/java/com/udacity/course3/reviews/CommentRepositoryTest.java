package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comments;
import com.udacity.course3.reviews.entity.Products;
import com.udacity.course3.reviews.entity.Reviews;
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
        Products products = new Products();
        products.setName("testProduct1");
        products.setInfo("info for product1");
        entityManager.persist(products);

        //Create Review
        Reviews reviews = new Reviews();
        reviews.setProductID(products.getProductID());
        reviews.setContent("review for product1");
        entityManager.persist(reviews);


        //Create Comment
        Comments comment = new Comments();
        comment.setReviewID(reviews.getReviewID());
        comment.setContent("comment for review");
        entityManager.persist(comment);

        List<Comments> realComment = commentRepository.findByReviewID(reviews.getReviewID());
        assertThat(realComment, is(notNullValue()));
        assertEquals(reviews.getReviewID(), realComment.get(0).getReviewID());

    }
}
