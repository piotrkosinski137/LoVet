package com.project.auth;

import com.project.domain.auth.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

  private BaseEntity baseEntity;

  public UserPrincipal(BaseEntity baseEntity) {
    this.baseEntity = baseEntity;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.baseEntity.getRole().toString()));
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.baseEntity.getPassword();
  }

  @Override
  public String getUsername() {
    return this.baseEntity.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
