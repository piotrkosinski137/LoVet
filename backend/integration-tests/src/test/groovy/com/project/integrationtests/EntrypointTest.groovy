package com.project.integrationtests

import com.project.Main
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@AutoConfigureMockMvc
@SpringBootTest(classes = [Main.class])
abstract class EntrypointTest extends Specification {
  @Autowired
  protected MockMvc mockMvc

  protected ResultActions performGet(String urlTemplate) throws Exception {
    return this.mockMvc.perform(get(urlTemplate)
      .accept(MediaType.APPLICATION_JSON))
  }

  protected ResultActions performPost(Object obj, String url) throws Exception {
    return this.mockMvc.perform(post(url)
      .content(JsonMapper.toJsonString(obj))
      .contentType(MediaType.APPLICATION_JSON))
  }

  protected ResultActions performPut(Object obj, String url) throws Exception {
    return this.mockMvc.perform(put(url)
      .content(JsonMapper.toJsonString(obj))
      .contentType(MediaType.APPLICATION_JSON))
  }
}
