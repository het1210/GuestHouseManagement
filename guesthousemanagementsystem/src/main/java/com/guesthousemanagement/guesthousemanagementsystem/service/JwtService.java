package com.guesthousemanagement.guesthousemanagementsystem.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JwtService {

    Optional<String> generateToken(String userEmail);

    String extractUserName(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
