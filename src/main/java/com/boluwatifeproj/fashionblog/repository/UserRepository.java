package com.boluwatifeproj.fashionblog.repository;

import com.boluwatifeproj.fashionblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findByUsername(String username);
    boolean existsByUsername(String username);
}
