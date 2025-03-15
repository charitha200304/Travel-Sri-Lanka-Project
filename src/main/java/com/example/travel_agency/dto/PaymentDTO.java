package com.example.travel_agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private Long id;
    private Long userId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
}
