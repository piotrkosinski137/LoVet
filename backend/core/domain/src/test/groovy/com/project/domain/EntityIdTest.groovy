package com.project.domain

import com.project.domain.auth.EntityId
import spock.lang.Specification

class EntityIdTest extends Specification {

  def "should create entityId with random id"() {
    when:
    def entityId = EntityId.create()

    then:
    entityId.getValue() != null
  }
}
