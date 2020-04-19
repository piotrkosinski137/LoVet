package com.project.usecase.auth.impl;

import com.project.domain.auth.BaseEntity;
import com.project.usecase.auth.SaveBaseEntity;
import com.project.usecase.auth.gateway.BaseEntityCommandGateway;
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
