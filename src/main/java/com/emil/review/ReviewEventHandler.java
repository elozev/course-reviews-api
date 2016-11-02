package com.emil.review;

import com.emil.user.User;
import com.emil.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by emil on 11/2/16.
 */
@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {

    private final UserRepository userRepository;

    @Autowired
    public ReviewEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        review.setReviewer(user);
    }
}
