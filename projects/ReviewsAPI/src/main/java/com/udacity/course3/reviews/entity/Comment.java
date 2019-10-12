package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private int commentID;

    @Column(name = "content")
    @NotNull(message = "please add comment")
    private String content;

    @ManyToOne
    @JoinColumn(name = "reviewID")
    private Review review;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}

