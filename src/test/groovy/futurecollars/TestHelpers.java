package futurecollars;


import static pl.futurecollars.invoicing.db.memory.model.Vat.VAT_8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import pl.futurecollars.invoicing.db.Company;
import pl.futurecollars.invoicing.db.Invoice;
import pl.futurecollars.invoicing.db.InvoiceEntry;

public class TestHelpers {

  private static Object Vat;

  static Company company(int id) {
   return new Company(("$id").repeat(10),
        "ul. Bukowińska 24d/$id 02-703 Warszawa, Polska",
        "iCode Trust $id Sp. z o.o");
  }

  static void product(int id) {
    new InvoiceEntry("Programming course $id", BigDecimal.valueOf(id * 1000), BigDecimal.valueOf(id * 1000 * 0.08), VAT_8);
  }

  static void invoice(int id) {
    new Invoice(id, LocalDate.now(), company(id), company(id), List.of());
  }
}
