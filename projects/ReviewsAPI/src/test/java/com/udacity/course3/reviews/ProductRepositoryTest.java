package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private ProductRepository productRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertThat(dataSource, is(notNullValue()));
        assertThat(jdbcTemplate, is(notNullValue()));
        assertThat(entityManager, is(notNullValue()));
        assertThat(testEntityManager, is(notNullValue()));
        assertThat(productRepository, is(notNullValue()));
    }

    @Test
    public void testFindProductById(){

        Product product = new Product();

        product.setName("testProduct1");
        product.setInfo("info for product1");

        entityManager.persist(product);

        List<Product> realProduct = productRepository.findById(1);
        assertThat(realProduct, is(notNullValue()));
        assertEquals(product.getProductID(), realProduct.get(0).getProductID());

    }

}


