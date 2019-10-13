package com.udacity.course3.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class ReviewDocument {

    private String _id;

    @Id
    private int reviewID;

    private int productID;

    @NotNull(message = "please add content")
    private String content;

    private List<Comment> comment = new ArrayList<>();

    public ReviewDocument(){
    }

    public ReviewDocument(Review review){
        this.reviewID = review.getReviewID();
        this.productID = review.getProduct().getProductID();
        this.content = review.getContent();
    }

    public String get_id() {
        return _id;
    }

    public int getReviewID(){
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

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
