package com.example.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DestinationDTO {
        private Long id;
        private String name;
        private String location;
        private String description;
        private String imageURL;
        private String category;
}
