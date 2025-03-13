package com.example.travel_agency.entity;

import com.example.travel_agency.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Entity
    public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        @Column(nullable = false)
        private User user;

        @ManyToOne
        @JoinColumn(name = "hotel_id")
        @Column(nullable = false)
        private Hotel hotel;
        @Column(nullable = false)
        private LocalDate checkInDate;
        @Column(nullable = false)
        private LocalDate checkOutDate;
        @Column(nullable = false)
        private double totalPrice;

        @Enumerated(EnumType.STRING)
        private BookingStatus status;
    }

