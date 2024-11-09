package com.buildwithshiva.repository;

import com.buildwithshiva.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
