package pl.futurecollars.invoicing.db.file;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.Invoice;
import pl.futurecollars.invoicing.utils.FileService;
import pl.futurecollars.invoicing.utils.JsonService;

@AllArgsConstructor
public class FileBasedDatabase implements Database {

  private final FileService filesService;
  private final JsonService jsonService;
  private final IdService idService;
  private final Path databasePath;

  @Override
  public int save(Invoice invoice) {

      invoice.setId(idService.getNextIdAndIncrement());
      filesService.appendLineToFile(databasePath, jsonService.toJson(invoice));
      return invoice.getId();

  }

  @Override
  public Optional<Invoice> getById(int id) {

      return filesService.readAllLines(databasePath)
          .stream()
          .filter(line -> containsId(line, id))
          .map(line -> jsonService.toObject(line, Invoice.class))
          .findFirst();
  }

  private boolean containsId(String line, int id) {
    return line.contains("\"id\":" + id + ",");
  }

  @Override
  public List<Invoice> getAll() {

      return filesService.readAllLines(databasePath)
          .stream()
          .map(line -> jsonService.toObject(line, Invoice.class))
          .collect(Collectors.toList());

  }

  @Override
  public void update(int id, Invoice updatedInvoice) {

      List<String> allInvoices = filesService.readAllLines(databasePath);
      var invoicesWithoutInvoiceWithGivenId = allInvoices
          .stream()
          .filter(line -> !containsId(line, id))
          .collect(Collectors.toList());
      updatedInvoice.setId(id);
      invoicesWithoutInvoiceWithGivenId.add(jsonService.toJson(updatedInvoice));
      filesService.writeLinesToFile(databasePath, invoicesWithoutInvoiceWithGivenId);
      allInvoices.removeAll(invoicesWithoutInvoiceWithGivenId);


  }

  @Override
  public void delete(int id) {

      var allInvoices = filesService.readAllLines(databasePath);
      var invoicesExceptDeleted = allInvoices
          .stream()
          .filter(line -> !containsId(line, id))
          .collect(Collectors.toList());
      filesService.writeLinesToFile(databasePath, invoicesExceptDeleted);
      allInvoices.removeAll(invoicesExceptDeleted);


  }
}