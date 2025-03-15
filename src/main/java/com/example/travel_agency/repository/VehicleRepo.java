package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByAvailability(boolean availability);

    List<Vehicle> findByType(String type);

    List<Vehicle> findByCapacityGreaterThanEqual(int minCapacity);
}
