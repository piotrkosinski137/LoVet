package com.project.usecase.auth.gateway;

import com.project.domain.auth.BaseEntity;

import java.util.Optional;

public interface BaseEntityQueryGateway {

  Optional<BaseEntity> loadByUsername(String username);
}
