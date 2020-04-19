package com.project.integrationtests.auth

import com.project.auth.jwt.JwtProperties
import com.project.auth.jwt.JwtUtils
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.TextCodec
import org.springframework.security.core.userdetails.UserDetails
import spock.lang.Specification

class JwtUtilsTest extends Specification {

  private def jwtUtils = new JwtUtils()
  private def userDetails = Mock(UserDetails)

  def "should validate token base on it's subject"() {
    given:
    userDetails.getUsername() >> subject

    when:
    def isTokenValid = jwtUtils.validateToken(generateToken(), userDetails)

    then:
    isTokenValid == result

    where:
    subject          | result
    "username"       | true
    "invalidSubject" | false

  }

  static String generateToken() {
    return Jwts.builder()
      .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(JwtProperties.JWT_SECRET))
      .setSubject("username")
      .setExpiration(new Date(2099,3,3))
      .compact()
  }
}
