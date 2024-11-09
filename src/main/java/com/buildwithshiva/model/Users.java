package com.buildwithshiva.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // Renamed to follow Java conventions

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String accessToken; // Renamed to follow Java conventions

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // Renamed to follow Java conventions

    @Column(nullable = false, updatable = true)
    private String role;

    @Column(nullable = false, updatable = true)
    private Boolean isActive; // Renamed to follow Java conventions

    @Column(nullable = false, updatable = true)
    private LocalDateTime lastLogin; // Renamed to follow Java conventions

    // Default constructor
    public Users() {
        // No-arg constructor required by JPA
    }

    // Constructor to set all required fields except ID
    public Users(String name, String email, String accessToken, LocalDateTime createdAt, String role, Boolean isActive) {
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
        this.createdAt = createdAt;
        this.role = role;
        this.isActive = isActive;
        this.lastLogin = LocalDateTime.now(); // Set the lastLogin to current time by default
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setAccessToken(String accessToken){
        this.accessToken=accessToken;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
