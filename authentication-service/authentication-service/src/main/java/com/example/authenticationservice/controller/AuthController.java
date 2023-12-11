package com.example.authenticationservice.controller;


import com.example.authenticationservice.dto.RequestAuth;
import com.example.authenticationservice.entity.UserIdentity;
import com.example.authenticationservice.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserIdentity user) {
        return identityService.saveUser(user);
    }


    @PostMapping("/token")
    public String getToken(@RequestBody RequestAuth requestAuth){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestAuth.getUsername(), requestAuth.getPassword()));
        if (authenticate.isAuthenticated()) {
            return identityService.generateToken(requestAuth.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
         identityService.validateToken(token);
         return "Token is valid";
    }
}
