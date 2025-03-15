package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByEntityTypeAndEntityId(String entityType, Long entityId);

    List<Review> findByUserId(Long userId);
}
