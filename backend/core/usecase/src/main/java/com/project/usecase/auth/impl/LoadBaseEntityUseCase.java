package com.project.usecase.auth.impl;

import com.project.domain.auth.BaseEntity;
import com.project.usecase.auth.LoadBaseEntity;
import com.project.usecase.auth.gateway.BaseEntityQueryGateway;
import com.project.usecase.auth.impl.exceptions.BaseEntityNotFound;
import org.springframework.stereotype.Service;

@Service
public class LoadBaseEntityUseCase implements LoadBaseEntity {

  private final BaseEntityQueryGateway gateway;

  public LoadBaseEntityUseCase(BaseEntityQueryGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public BaseEntity loadByUsername(String username) {
    return gateway.loadByUsername(username).orElseThrow(() -> new BaseEntityNotFound(username));
  }
}
