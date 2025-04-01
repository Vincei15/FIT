package com.example.demo;

import java.time.LocalDateTime;

public class AdminUser {
    
        private Long id;
        private String username;
        private String email;
        private String role;
        private AccountStatus accountStatus; // Enum: ACTIVE, BANNED, SUSPENDED
        private LocalDateTime createdDate;
        private LocalDateTime lastLogin;
        private String name;
        private String address;
    
        // Constructor, getters and setters, etc.
    }
    
