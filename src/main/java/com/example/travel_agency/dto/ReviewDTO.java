package com.example.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDTO {
    private Long id;
    private Long userId;
    private String entityType;
    private Long entityId;
    private double rating;
    private String comment;
    private LocalDate date;
}
