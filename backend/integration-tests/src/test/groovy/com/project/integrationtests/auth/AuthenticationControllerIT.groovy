package com.project.integrationtests.auth

import com.project.auth.controller.JwtAuthenticationRequest
import com.project.integrationtests.EntrypointTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class AuthenticationControllerIT extends EntrypointTest {

  @Autowired
  MockMvc mockMvc

  @Autowired
  private WebApplicationContext context

  def "should return token after successful login"() {
    given:
    def request = new JwtAuthenticationRequest("test", "test")

    when:
    def result = performPost(request, "/auth")

    then:
    result.andExpect(status().isOk())
    result.andExpect(jsonPath('$.token').exists())
  }

  def "should return forbidden when provided credentials are invalid"() {
    given:
    def request = new JwtAuthenticationRequest("wrongUsername", "wrongPassword")

    when:
    def result = performPost(request, "/auth")

    then:
    result.andExpect(status().isForbidden())
  }
}
