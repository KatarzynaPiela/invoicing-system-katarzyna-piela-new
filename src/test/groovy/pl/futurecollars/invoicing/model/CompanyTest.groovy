package pl.futurecollars.invoicing.model

import spock.lang.Specification

class  CompanyTest extends Specification {

        def "constructor should properly initialize fields"() {
            given:
            def id = 1
            def taxIdentificationNumber = "0000000001"
            def address = "Warszawska"
            def name = "Laura Margo"
            def healtInsurance = 0.00
            def pensionInsurance = 0.00

            when:
            def company = new Company(id, taxIdentificationNumber, address, name, healtInsurance, pensionInsurance)

            then:
            company.taxIdentificationNumber == taxIdentificationNumber
            company.address == address
            company.name == name
            company.healthInsurance == healtInsurance
            company.pensionInsurance == pensionInsurance
        }

        def "getter and setter methods should work correctly"() {
            given:
            def company = new Company(1,"0000000002", "Grove Street Home", "New Invesment Corp", 0.00, 0.00)

            when:
            company.setTaxIdentificationNumber("0000000001")
            company.setAddress("Warszawska")
            company.setName("Laura Margo")
            company.setHealthInsurance(0.00)
            company.setPensionInsurance(0.00)
            then:
            company.getAddress() == "Warszawska"
            company.getTaxIdentificationNumber() == "0000000001"
            company.getName() == "Laura Margo"
            company.getHealthInsurance() == 0
            company.getPensionInsurance() == 0
        }
    }