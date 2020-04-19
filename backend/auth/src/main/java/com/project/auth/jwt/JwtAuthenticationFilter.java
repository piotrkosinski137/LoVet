package com.project.auth.jwt;

import static com.project.auth.jwt.JwtProperties.TOKEN_HEADER;
import static com.project.auth.jwt.JwtProperties.TOKEN_PREFIX;

import com.project.auth.UserPrincipalDetailsService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtUtils jwtUtils;
  private final UserPrincipalDetailsService userDetailsService;

  public JwtAuthenticationFilter(JwtUtils jwtUtils, UserPrincipalDetailsService userDetailsService) {
    this.jwtUtils = jwtUtils;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
    FilterChain chain) throws IOException, ServletException {
    String header = request.getHeader(TOKEN_HEADER);

    if (isHeaderValid(header)) {
      String token = header.replace("Bearer ", "");
      UserDetails userDetails = userDetailsService
        .loadUserByUsername(jwtUtils.extractUsername(token));

      if (isTokenValid(token, userDetails)) {
        setSecurityContextAuth(userDetails);
      }
    }
    chain.doFilter(request, response);
  }

  private boolean isHeaderValid(String header) {
    return header != null && header.startsWith(TOKEN_PREFIX);
  }

  private Boolean isTokenValid(String token, UserDetails userDetails) {
    return jwtUtils.validateToken(token, userDetails);
  }

  private void setSecurityContextAuth(UserDetails userDetails) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
      userDetails, null, userDetails.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
  }
}
