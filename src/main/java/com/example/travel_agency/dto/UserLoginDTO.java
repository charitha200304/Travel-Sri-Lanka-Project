package com.example.travel_agency.dto;

import com.example.travel_agency.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {
    private String username;
    private String password;
    private Role role;
}
