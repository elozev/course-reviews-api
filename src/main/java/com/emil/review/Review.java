package com.emil.review;

import com.emil.core.BaseEntity;
import com.emil.course.Course;
import com.emil.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by emil on 11/2/16.
 */
@Entity
public class Review extends BaseEntity {

    private int rating;
    private String description;
    @ManyToOne
    private Course course;
    @ManyToOne // One user can have many reviews
    private User reviewer;

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User user) {
        this.reviewer = user;
    }

    // TODO: We are duplicating code for every single entity
    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this();
        this.rating = rating;
        this.description = description;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
