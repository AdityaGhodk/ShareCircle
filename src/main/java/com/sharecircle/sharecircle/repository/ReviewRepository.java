
package com.sharecircle.sharecircle.repository;

import com.sharecircle.sharecircle.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByUserId(Long userId);

    List<Review> findByItemId(Integer itemId);

    List<Review> findByRating(Integer rating);
}
