package com.project.integrationtests

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper

class JsonMapper {
  private static ObjectMapper mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)

  static toJsonString(Object obj) {
    mapper.writeValueAsString(obj)
  }
}
