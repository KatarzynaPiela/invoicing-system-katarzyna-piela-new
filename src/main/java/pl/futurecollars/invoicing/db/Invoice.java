package pl.futurecollars.invoicing.db;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Invoice {
  private int id;
  private LocalDate date;
  private Company buyer;
  private Company seller;
  private List<InvoiceEntry> entries;

}
