import spock.lang.Specification

class AppTest extends Specification {
  def "application has a greeting"()

  {

    def "dummy test to cover main" () {
    setup:
    def app = new App()

    when:
    def result = app.greeting

    then:
    result != null
    and:
    app.main()
  }
  }