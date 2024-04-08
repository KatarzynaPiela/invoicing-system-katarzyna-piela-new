package pl.futurecollars.invoicing.db;

import java.math.BigDecimal;
import pl.futurecollars.invoicing.db.memory.model.Vat;

public class InvoiceEntry {

  private String description;
  private BigDecimal price;
  private BigDecimal vatValue;
  private Vat vatRate;

  public InvoiceEntry(String description, BigDecimal price, BigDecimal vatValue, Vat vatRate) {
    this.description = description;
    this.price = price;
    this.vatValue = vatValue;
    this.vatRate = vatRate;
  }
}
