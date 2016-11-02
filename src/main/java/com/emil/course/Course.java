package com.emil.course;

import com.emil.core.BaseEntity;
import com.emil.review.Review;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emil on 11/2/16.
 */
@Entity
public class Course extends BaseEntity{
    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    private String url;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    //Only classes in this package can access it
    protected Course(){
        super();
        reviewList = new ArrayList<>();
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void addReview(Review review){
        review.setCourse(this);
        reviewList.add(review);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
