package com.example.travel_agency.repository;

import com.example.travel_agency.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {
    List<University> findByRankingGreaterThanEqual(double ranking);
}
