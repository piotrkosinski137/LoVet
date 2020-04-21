package com.project.auth.gateway;

import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.EntityId;
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
  public EntityId save(BaseEntity baseEntity) {
    return repository.save(baseEntity).getId();
  }

  @Override
  public Optional<BaseEntity> findByUsername(String username) {
    return repository.findByCredentialsEmail(username);
  }

  @Override
  public boolean existsByEmail(String username) {
    return repository.existsByCredentialsEmail(username);
  }
}
