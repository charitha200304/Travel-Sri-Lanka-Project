package com.example.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UniversityDTO {
    private Long id;
    private String name;
    private String location;
    private double ranking;
    private String contactInfo;
}
