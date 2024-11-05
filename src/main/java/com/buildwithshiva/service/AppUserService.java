package com.buildwithshiva.service;

import com.buildwithshiva.dto.CreateUserRequest;
import com.buildwithshiva.model.AppUser;
import com.buildwithshiva.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    // Method to create a new user
    public AppUser createUser(CreateUserRequest createUserRequest) {
        // Check if user already exists
        Optional<AppUser> existingUser = appUserRepository.findByEmail(createUserRequest.getEmail());

        AppUser user;
        if (existingUser.isPresent()) {
            // Update existing user's access token and other information
            user = existingUser.get();
            user.setAccessToken(createUserRequest.getAccessToken());
            // Update any other fields as necessary
            appUserRepository.save(user); // Save the updated user
        } else {
            // Create a new user if it does not exist
            user = new AppUser(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getAccessToken(), LocalDateTime.now(), createUserRequest.getUserRole());
            appUserRepository.save(user);
        }
        return user;
    }
    }
