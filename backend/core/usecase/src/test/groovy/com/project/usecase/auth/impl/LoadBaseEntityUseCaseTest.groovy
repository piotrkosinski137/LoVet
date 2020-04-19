package com.project.usecase.auth.impl

import com.project.domain.auth.BaseEntity
import com.project.usecase.auth.gateway.BaseEntityQueryGateway
import com.project.usecase.auth.impl.exceptions.BaseEntityNotFound
import spock.lang.Specification

class LoadBaseEntityUseCaseTest extends Specification {

  private def baseEntityQueryGateway = Mock(BaseEntityQueryGateway)
  private def loadBaseEntity = new LoadBaseEntityUseCase(baseEntityQueryGateway)

  def "should return BaseEntity based on it's username"() {
    given:
    def username = "username"
    def baseEntity = Mock(BaseEntity)
    baseEntityQueryGateway.loadByUsername(username) >> Optional.of(baseEntity)

    when:
    def result = loadBaseEntity.loadByUsername(username)

    then:
    result == baseEntity
  }

  def "should throw exception when there is no BaseEntity with given username"() {
    given:
    baseEntityQueryGateway.loadByUsername(_ as String) >> Optional.empty()

    when:
    loadBaseEntity.loadByUsername("unknownUsername")

    then:
    thrown(BaseEntityNotFound)
  }
}
