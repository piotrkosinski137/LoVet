package com.project.gateway;

import com.project.domain.auth.BaseEntity;
import com.project.usecase.auth.gateway.BaseEntityCommandGateway;
import com.project.usecase.auth.gateway.BaseEntityQueryGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseBaseEntityGateway implements BaseEntityCommandGateway, BaseEntityQueryGateway {

  private final BaseEntityRepository repository;

  public DatabaseBaseEntityGateway(BaseEntityRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(BaseEntity baseEntity) {
    repository.save(baseEntity);
  }

  @Override
  public Optional<BaseEntity> loadByUsername(String username) {
    return repository.findByCredentialsUsername(username);
  }
}
