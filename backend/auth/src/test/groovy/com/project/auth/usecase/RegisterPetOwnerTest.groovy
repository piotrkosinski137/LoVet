package com.project.auth.usecase

import com.project.auth.controller.dto.RegisterPetOwnerDto
import com.project.auth.domain.BaseEntity
import com.project.auth.domain.EntityId
import com.project.auth.domain.usecase.LoadBaseEntity
import com.project.auth.domain.usecase.SaveBaseEntity
import com.project.auth.usecase.exceptions.InvalidEmailSyntax
import com.project.auth.usecase.exceptions.PetOwnerAlreadyExist
import com.project.event.PetOwnerCreated
import org.springframework.context.ApplicationEventPublisher
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import spock.lang.Unroll

class RegisterPetOwnerTest extends Specification {

    def encoder = Mock(PasswordEncoder)
    def loadBaseEntity = Mock(LoadBaseEntity)
    def saveBaseEntity = Mock(SaveBaseEntity)
    def publisher = Mock(ApplicationEventPublisher)
    def registerPetOwner = new RegisterPetOwner(loadBaseEntity, saveBaseEntity, publisher, encoder)

    def "should save users only with valid email"() {
        given:
        loadBaseEntity.existsByEmail(email) >> false
        saveBaseEntity.save(_ as BaseEntity) >> EntityId.create()

        when:
        registerPetOwner.register([email: email] as RegisterPetOwnerDto)

        then:
        1 * publisher.publishEvent(_ as PetOwnerCreated)

        where:
        email                | _
        "email@o2.com"       | _
        "email123@gmail.com" | _
        "email123@wp.com"    | _
        "email123@vp.de"     | _
        "email123@tlen.pl"   | _
    }

    @Unroll
    def "should throw exception when email #email is invalid"() {
        given:
        loadBaseEntity.existsByEmail(email) >> false
        saveBaseEntity.save(_ as BaseEntity) >> EntityId.create()

        when:
        registerPetOwner.register([email: email] as RegisterPetOwnerDto)

        then:
        thrown(InvalidEmailSyntax)

        where:
        email              | _
        "email@com"        | _
        "@gmail.com"       | _
        "@email123@wp.com" | _
        "email123@vp.de."  | _
        "email123@.pl"     | _
    }


    def "should not save user if email already exists inside db"() {
        given:
        def email = "email@gmail.com"
        loadBaseEntity.existsByEmail(email) >> true

        when:
        registerPetOwner.register([email: email] as RegisterPetOwnerDto)

        then:
        thrown(PetOwnerAlreadyExist)
    }
}
