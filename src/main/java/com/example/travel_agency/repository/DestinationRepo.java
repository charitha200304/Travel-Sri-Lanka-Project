package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepo extends JpaRepository<Destination, Long> {
    List<Destination> findByCategory(String category);
}
