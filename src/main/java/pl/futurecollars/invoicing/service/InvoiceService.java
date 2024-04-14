package pl.futurecollars.invoicing.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;

public class InvoiceService {

  private final Database database;

  public InvoiceService(Database database) {
    this.database = database;
  }

  public int save(Invoice invoice) {
    return database.save(invoice);
  }

  public Optional<Invoice> getById(int id) {
    return database.getById(id);
  }

  public List<Invoice> getAll() {
    return database.getAll();
  }

  public ResponseEntity<Invoice> update(int id, Invoice updatedInvoice) {
    database.update(id, updatedInvoice);
    return null;
  }

  public ResponseEntity<Invoice> delete(int id) {
    database.delete(id);
    return null;
  }

}
