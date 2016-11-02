package com.emil.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by emil on 11/2/16.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.username == authentication.name")
    void delete(@Param("id")Long id);

    @Override
    @PreAuthorize("hasRole('Role_ADMIN') or #review.reviewer?.username == authentication.name")
    void delete(@Param("review")Review entity);
}
