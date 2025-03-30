package com.example.travel_agency.controller;

import com.example.travel_agency.dto.AuthTokenDTO;
import com.example.travel_agency.dto.UserLoginDTO;
import com.example.travel_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/verify")
    public AuthTokenDTO verify(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.verifyUser(userLoginDTO);
    }

}
