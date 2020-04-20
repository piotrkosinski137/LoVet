package com.project.auth.usecase;

import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.usecase.LoadBaseEntity;
import com.project.auth.usecase.gateway.BaseEntityQueryGateway;
import com.project.auth.usecase.exceptions.BaseEntityNotFound;
import org.springframework.stereotype.Service;

@Service
public class LoadBaseEntityUseCase implements LoadBaseEntity {

  private final BaseEntityQueryGateway gateway;

  public LoadBaseEntityUseCase(BaseEntityQueryGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public BaseEntity findByUsername(String username) {
    return gateway.loadByUsername(username).orElseThrow(() -> new BaseEntityNotFound(username));
  }

  @Override
  public boolean existsByEmail(String username) {
    return gateway.existsByUsername(username);
  }
}
