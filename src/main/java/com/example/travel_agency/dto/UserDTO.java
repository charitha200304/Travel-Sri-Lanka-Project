package com.example.travel_agency.dto;

import com.example.travel_agency.enums.Role;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role role;


}