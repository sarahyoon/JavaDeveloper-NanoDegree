package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsRepositoryTest {


    @Autowired private EntityManager entityManager;
    @Autowired private ReviewRepository reviewRepository;


    @Test
    public void testFindReviewByProductId(){

        //Create product
        Product product = new Product();

        product.setName("testProduct1");
        product.setInfo("info for product1");

        entityManager.persist(product);

        //Create Review
        Review review = new Review();
        review.setProduct(product);
        review.setContent("review for product1");

        entityManager.persist(review);

        List<Review> realReview = reviewRepository.findByProduct(product);
        assertThat(realReview, is(notNullValue()));
        assertEquals(product.getProductID(), realReview.get(0).getProduct().getProductID());

    }

}
