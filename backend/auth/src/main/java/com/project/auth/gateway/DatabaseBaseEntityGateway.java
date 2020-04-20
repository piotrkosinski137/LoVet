package com.project.auth.gateway;

import com.project.auth.domain.BaseEntity;
import com.project.auth.usecase.gateway.BaseEntityCommandGateway;
import com.project.auth.usecase.gateway.BaseEntityQueryGateway;
import java.util.Optional;
import org.springframework.stereotype.Service;

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
