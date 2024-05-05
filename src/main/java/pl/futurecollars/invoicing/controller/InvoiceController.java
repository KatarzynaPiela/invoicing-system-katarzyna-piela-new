package pl.futurecollars.invoicing.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.service.InvoiceService;

@Slf4j
@RestController
@RequestMapping("invoices")
public class InvoiceController {

  public class InvoiceControllers implements InvoiceApi {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceControllers(InvoiceService invoiceService) {
      this.invoiceService = invoiceService;
    }

    @GetMapping(produces = {"application/json;charset=UTF-8"})
    @Override
    public List<Invoice> getAll() {
      return invoiceService.getAll();
    }

    @PostMapping
    @Override
    public int add(@RequestBody Invoice invoice) {
      log.info("Używam postMapping update - info");
      return invoiceService.save(invoice);
    }

    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    @Override
    public ResponseEntity<Invoice> getById(@PathVariable int id) {
      log.info("Używam getMapping update - info");
      return invoiceService.getById(id)
          .map(invoice -> ResponseEntity.ok().body(invoice))
          .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteById(@PathVariable int id) {
      log.info("Używam deleteMapping update - info");
      return invoiceService.delete(id)
          .map(name -> ResponseEntity.noContent().build())
          .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Invoice invoice) {
      log.info("Używam putMapping update - info");
      return invoiceService.update(id, invoice)
          .map(name -> ResponseEntity.noContent().build())
          .orElse(ResponseEntity.notFound().build());
    }
  }
}

