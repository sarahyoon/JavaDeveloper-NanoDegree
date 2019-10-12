package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@NotNull
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int productID;

    @Column(name = "name")
    @NotNull(message = "please add name")
    private String name;

    @Column(name = "info")
    @NotNull(message = "please add info")
    private String info;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Review> review = new ArrayList<>();

    public int getProductID() {
        return productID;
    }

    public void setProductID(int id) {this.productID = productID;}

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

