package com.project.auth.usecase.impl;

import com.project.auth.domain.BaseEntity;
import com.project.auth.usecase.SaveBaseEntity;
import com.project.auth.usecase.gateway.BaseEntityCommandGateway;
import org.springframework.stereotype.Service;

@Service
public class SaveBaseEntityUseCase implements SaveBaseEntity {

  private final BaseEntityCommandGateway gateway;

  public SaveBaseEntityUseCase(BaseEntityCommandGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public void save(BaseEntity baseEntity) {
    gateway.save(baseEntity);
  }
}
