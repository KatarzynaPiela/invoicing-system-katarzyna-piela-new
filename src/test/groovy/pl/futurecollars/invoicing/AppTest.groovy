/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package pl.futurecollars.invoicing

import spock.lang.Specification

class AppTest extends Specification {

    def "application has a greeting"() {
        setup:
        def app = new App()

        when:
        def result = app.greeting

        then:
        result != null
    }

    def "dumny test to cover main"(){
        setup:
        def app = new App()

        and:
        app.main()
    }
}
