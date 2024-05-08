package pl.futurecollars.invoicing.model

import spock.lang.Specification

class InvoiceTest extends Specification {

    def invoiceEntry = InvoiceEntry.builder()
            .description("Laptop")
            .quantity(1)
            .price(new BigDecimal("1000.00"))
            .vatValue(new BigDecimal("230.00"))
            .vatRate(Vat.VAT_23).build()

    def invoice = Invoice.builder()
            .date(LocalDate.now())
            .buyer(new Company(name: "bb", taxIdentifications: "213123123"))
            .seller(new Company(name: "bb", taxIdentifications: "213123123"))
            .entries([invoiceEntry]).build()

}




