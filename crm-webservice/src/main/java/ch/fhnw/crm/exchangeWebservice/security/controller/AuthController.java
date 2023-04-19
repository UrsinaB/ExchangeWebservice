package ch.fhnw.crm.exchangeWebservice.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.crm.exchangeWebservice.security.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        System.out.println("Inside /token request...");
        if (authentication.isAuthenticated()) {
            return tokenService.generateToken(authentication);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
