package com.example.authenticationservice.service;


import com.example.authenticationservice.entity.UserIdentity;
import com.example.authenticationservice.repository.UserIdentityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    @Autowired
    private UserIdentityRepo userIdentityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserIdentity userIdentity){
        userIdentity.setPassword(passwordEncoder.encode(userIdentity.getPassword()));
        userIdentityRepo.save(userIdentity);
        return "User is added";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
