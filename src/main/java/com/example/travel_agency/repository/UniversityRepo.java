package com.example.travel_agency.repository;

import com.example.travel_agency.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepo extends JpaRepository<University, Long> {
    List<University> findByRankingGreaterThanEqual(double ranking);
}
