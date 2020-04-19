package com.project.auth.jwt;

import static com.project.auth.jwt.JwtProperties.EXPIRATION_TIME;
import static com.project.auth.jwt.JwtProperties.JWT_SECRET;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {

  public String extractUsername(String token) {
    return extractClaims(token).getSubject();
  }

  private Claims extractClaims(String token) {
    return Jwts.parser()
      .setSigningKey(JWT_SECRET)
      .parseClaimsJws(token)
      .getBody();
  }

  public String generateToken(String username) {
    return Jwts.builder()
      .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(JWT_SECRET))
      .setSubject(username)
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
      .compact();
  }


  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return username.equals(userDetails.getUsername());
  }
}
