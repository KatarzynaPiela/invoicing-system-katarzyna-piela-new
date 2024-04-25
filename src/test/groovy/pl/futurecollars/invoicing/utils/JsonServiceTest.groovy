package pl.futurecollars.invoicing.utils

import pl.futurecollars.invoicing.helpers.TestHelpers
import pl.futurecollars.invoicing.model.Invoice
import spock.lang.Specification;

class JsonServiceTest extends Specification {
    def "Convert Object to Json and read it back"() {
        given:
        def jsonService = new JsonService()
        def invoice = TestHelpers.invoice(1)

        when:
        def invoiceAsString = jsonService.toJson(invoice)
        and:
        def invoiceFromJson = jsonService.toObject(invoiceAsString, Invoice)

        then:
        invoiceFromJson == invoice
    }

    def "should throw exception when json is incorrect"() {
        given:
        def jsonService = new JsonService()
        def incorrectJson = '{'

        when:
        jsonService.toObject(incorrectJson, Invoice)

        then:
        thrown(JsonMappingException)
    }
}
