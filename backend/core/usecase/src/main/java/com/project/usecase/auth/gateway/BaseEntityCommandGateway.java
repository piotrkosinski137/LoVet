package com.project.usecase.auth.gateway;

import com.project.domain.auth.BaseEntity;

public interface BaseEntityCommandGateway {

  void save(BaseEntity baseEntity);
}
