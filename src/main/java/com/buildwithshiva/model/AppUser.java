package com.buildwithshiva.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String accessToken;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = true)
    private String userRole;

    // Default constructor
    public AppUser() {
        // No-arg constructor required by JPA
    }

    // Constructor to set all required fields except ID
    public AppUser(String name, String email, String accessToken, LocalDateTime createdAt, String userRole) {
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
        this.createdAt = createdAt;
        this.userRole = userRole;
    }

    // Only Getters provided for these fields to keep them immutable
    public Long getId() {
        return id;
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

    public String getUserRole() {
        return userRole;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
