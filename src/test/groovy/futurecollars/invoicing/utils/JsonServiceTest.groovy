package futurecollars.invoicing.utils

import futurecollars.invoicing.helpers.TestHelpers
import pl.futurecollars.invoicing.utils.JsonService
import spock.lang.Specification;


class JsonServiceTest extends Specification {
    def "Convert Object to Json and read it back"() {
        given:
        def jsonService = new JsonService()
        def invoice = TestHelpers.invoice(1)

        when:
        def invoiceAsString = jsonService.toJson(invoice)
        and:
        def invoiceFromJson = jsonService.toObject(invoiceAsString, invoice)

        then:
        invoiceFromJson == invoice
    }
}

