package com.project.auth.usecase.gateway;

import com.project.auth.domain.BaseEntity;

public interface BaseEntityCommandGateway {

  void save(BaseEntity baseEntity);
}
