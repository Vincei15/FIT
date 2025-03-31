package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;
    private Long userID;
    private Long serviceID;
    private int rating;
    private String details;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    public Review() {}

    public Long getReviewID() { return reviewID; }
    public void setReviewID(Long reviewID) { this.reviewID = reviewID; }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public Long getServiceID() { return serviceID; }
    public void setServiceID(Long serviceID) { this.serviceID = serviceID; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}