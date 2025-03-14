package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocation(String location);
}
