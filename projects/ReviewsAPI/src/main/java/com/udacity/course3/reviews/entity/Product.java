package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int productID;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @OneToMany
    @JoinColumn(name = "reviewID")
    private List<Review> review = new ArrayList<>();

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Review> getReview() {
        return review;
    }
}

