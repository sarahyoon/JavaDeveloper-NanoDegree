package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Products;
import com.udacity.course3.reviews.entity.Reviews;
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
        Products products = new Products();

        products.setName("testProduct1");
        products.setInfo("info for product1");

        entityManager.persist(products);

        //Create Review
        Reviews reviews = new Reviews();
        reviews.setProductID(products.getProductID());
        reviews.setContent("review for product1");

        entityManager.persist(reviews);

        List<Reviews> realReview = reviewRepository.findByProductID(products.getProductID());
        assertThat(realReview, is(notNullValue()));
        assertEquals(products.getProductID(), realReview.get(0).getProductID());

    }

}
