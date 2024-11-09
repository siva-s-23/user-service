package com.buildwithshiva.service;

import com.buildwithshiva.dto.CreateUserRequest;
import com.buildwithshiva.model.Users;
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
    public Users createUser(CreateUserRequest createUserRequest) {
        // Check if user already exists
        Optional<Users> existingUser = appUserRepository.findByEmail(createUserRequest.getEmail());

        Users user;
        if (existingUser.isPresent()) {
            // Update existing user's access token and other information
            user = existingUser.get();
            user.setAccessToken(createUserRequest.getAccessToken());
            // Update any other fields as necessary
            appUserRepository.save(user); // Save the updated user
        } else {
            // Create a new user if it does not exist
            user = new Users(
                    createUserRequest.getName(),
                    createUserRequest.getEmail(),
                    createUserRequest.getAccessToken(),
                    LocalDateTime.now(),
                    createUserRequest.getRole(),
                    true
            );
            user.setLastLogin(LocalDateTime.now());
            appUserRepository.save(user);
        }
        return user;
    }
    }
