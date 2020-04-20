import com.project.auth.domain.BaseEntity
import com.project.auth.usecase.gateway.BaseEntityQueryGateway
import com.project.auth.usecase.impl.LoadBaseEntityUseCase
import com.project.auth.usecase.impl.exceptions.BaseEntityNotFound
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
