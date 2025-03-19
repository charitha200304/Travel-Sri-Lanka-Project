package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocation(String location);
}
