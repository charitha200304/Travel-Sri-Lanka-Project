package com.example.travel_agency.controller;

import com.example.travel_agency.dto.UserDTO;
import com.example.travel_agency.service.JWTService;
import com.example.travel_agency.service.UserService;
import com.example.travel_agency.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JWTService jwtService;

    public UserController(UserService userService, JWTService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    // Get user by JWT token
    @GetMapping("/getUser")
    public ResponseEntity<ResponseUtil> getUser(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ResponseUtil(401, "Unauthorized", null));
        }

        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);
        UserDTO userDTO = userService.getUserByEmail(username);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseUtil(200, "User fetched successfully", userDTO));
    }

    // Get user by ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseUtil> getUserById(@PathVariable Long id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil(200, "User fetched successfully", userDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }

    // Get all users
    @GetMapping("/getAll")
    public ResponseEntity<ResponseUtil> getAllUsers() {
        try {
            List<UserDTO> users = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil(200, "Users fetched successfully", users));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }

    // Get users by role
    @GetMapping("/getByRole/{role}")
    public ResponseEntity<ResponseUtil> getUsersByRole(@PathVariable String role) {
        try {
            List<UserDTO> users = userService.getUsersByRole(role);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil(200, "Users fetched successfully", users));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }

    // Get user by email
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<ResponseUtil> getUserByEmail(@PathVariable String email) {
        try {
            UserDTO userDTO = userService.getUserByEmail(email);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil(200, "User fetched successfully", userDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }

    // Add a new user
    @PostMapping("/addUser")
    public ResponseEntity<ResponseUtil> addUser(@RequestBody UserDTO userDTO) {
        try {
            userService.save(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseUtil(201, "User added successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }

    // Update user
    @PutMapping("/updateUser")
    public ResponseEntity<ResponseUtil> updateUser(@RequestBody UserDTO userDTO) {
        try {
            userService.update(userDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil(200, "User updated successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }

    // Delete user
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ResponseUtil> deleteUser(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil(200, "User deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500, e.getMessage(), null));
        }
    }
}
