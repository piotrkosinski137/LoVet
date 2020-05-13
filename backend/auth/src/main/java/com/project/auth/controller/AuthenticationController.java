package com.project.auth.controller;

import static com.project.commons.errors.SuccessCode.S_AUTH_01;

import com.project.auth.controller.dto.JwtAuthenticationRequest;
import com.project.auth.controller.dto.JwtAuthenticationResponse;
import com.project.auth.controller.dto.JwtRegisterResponse;
import com.project.auth.controller.dto.RegisterPetOwnerDto;
import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.usecase.LoadBaseEntity;
import com.project.auth.jwt.JwtUtils;
import com.project.auth.usecase.RegisterPetOwner;
import com.project.auth.usecase.exceptions.InvalidCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationManager authManager;
  private final JwtUtils jwtUtils;
  private final LoadBaseEntity loadBaseEntity;
  private final RegisterPetOwner registerPetOwner;

  public AuthenticationController(AuthenticationManager authManager, JwtUtils jwtUtils,
      LoadBaseEntity loadBaseEntity, RegisterPetOwner registerPetOwner) {
    this.authManager = authManager;
    this.jwtUtils = jwtUtils;
    this.loadBaseEntity = loadBaseEntity;
    this.registerPetOwner = registerPetOwner;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody JwtAuthenticationRequest request) {
    authenticate(request.getEmail(), request.getPassword());

    BaseEntity baseEntity = loadBaseEntity.findByUsername(request.getEmail());
    String jwt = jwtUtils.generateToken(baseEntity.getUsername());

    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
  }

  @PostMapping("/register/pet-owner")
  public JwtRegisterResponse register(@RequestBody RegisterPetOwnerDto dto) {
    registerPetOwner.register(dto);
    return new JwtRegisterResponse(S_AUTH_01.name());
  }

  private void authenticate(String email, String password) {
    try {
      authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    } catch (BadCredentialsException e) {
      throw new InvalidCredentials();
    }
  }
}
