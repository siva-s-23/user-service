package com.buildwithshiva.controller;

import com.buildwithshiva.dto.CreateUserRequest;
import com.buildwithshiva.model.AppUser;
import com.buildwithshiva.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Base URL for user-related operations
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // Endpoint to create a new user
    @PostMapping("/create")
    public ResponseEntity<AppUser> createUser(@RequestBody CreateUserRequest createUserRequest) {
        AppUser newUser = appUserService.createUser(createUserRequest);
        return ResponseEntity.status(201).body(newUser); // Return created user with HTTP 201 status
    }
}
