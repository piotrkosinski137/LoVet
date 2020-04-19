package com.project.auth.controller;

import com.project.auth.jwt.JwtUtils;
import com.project.domain.auth.BaseEntity;
import com.project.usecase.auth.LoadBaseEntity;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final LoadBaseEntity loadBaseEntity;

    public AuthenticationController(AuthenticationManager authManager, JwtUtils jwtUtils,
      LoadBaseEntity loadBaseEntity) {
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
        this.loadBaseEntity = loadBaseEntity;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody JwtAuthenticationRequest request) {
        authenticate(request.getUsername(), request.getPassword());

        BaseEntity baseEntity = loadBaseEntity.loadByUsername(request.getUsername());
        String jwt = jwtUtils.generateToken(baseEntity.getUsername());

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    private void authenticate(String username, String password) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new EntityNotFoundException("Wrong username or password!");
        }
    }
}
