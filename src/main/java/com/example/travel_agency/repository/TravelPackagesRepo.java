package com.example.travel_agency.repository;

import com.example.travel_agency.entity.TravelPackages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelPackagesRepo extends JpaRepository<TravelPackagesRepo, Long> {
    List<TravelPackages> findByBudgetBetween(Double minBudget, Double maxBudget);
}
