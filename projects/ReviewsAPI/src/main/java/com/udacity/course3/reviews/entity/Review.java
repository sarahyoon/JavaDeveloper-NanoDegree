package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAnyAttribute;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewID")
    private int reviewID;

    @Column(name = "content")
    @NotNull(message = "please add content")
    private String content;

    @ManyToOne
    @JoinColumn(name="productID")
    private Product product;

    @OneToMany(mappedBy = "review")
    @JsonIgnore
    private List<Comment> comment = new ArrayList<>();

    public void setReviewID(int reviewID){this.reviewID = reviewID; }

    public int getReviewID() {
        return reviewID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
