package com.udacity.course3.reviews.entity;

import javax.persistence.*;
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

    @Column(name = "productID")
    private int productID;

    @Column(name = "content")
    private String content;

    @OneToMany
    @JoinColumn(name = "commentID")
    private List<Comment> comment = new ArrayList<>();

    public int getReviewID() {
        return reviewID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
