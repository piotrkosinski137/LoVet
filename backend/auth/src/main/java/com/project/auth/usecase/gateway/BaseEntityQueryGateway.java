package com.project.auth.usecase.gateway;

import com.project.auth.domain.BaseEntity;
import java.util.Optional;

public interface BaseEntityQueryGateway {

  Optional<BaseEntity> findByUsername(String username);

  boolean existsByEmail(String username);
}
