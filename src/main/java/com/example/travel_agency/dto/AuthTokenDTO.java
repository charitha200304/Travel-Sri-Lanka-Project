package com.example.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthTokenDTO {
    private boolean authenticated;
    private String token;
    private String message;
}
