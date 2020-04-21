package com.project.auth.usecase;

import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.usecase.LoadBaseEntity;
import com.project.auth.usecase.gateway.BaseEntityQueryGateway;
import com.project.auth.usecase.exceptions.InvalidCredentials;
import org.springframework.stereotype.Service;

@Service
public class LoadBaseEntityUseCase implements LoadBaseEntity {

  private final BaseEntityQueryGateway gateway;

  public LoadBaseEntityUseCase(BaseEntityQueryGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public BaseEntity findByUsername(String email) {
    return gateway.findByUsername(email).orElseThrow(InvalidCredentials::new);
  }

  @Override
  public boolean existsByEmail(String email) {
    return gateway.existsByEmail(email);
  }
}
