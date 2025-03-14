package com.example.travel_agency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private double pricePerDay;
    @Column(nullable = false)
    private boolean availability;
}

