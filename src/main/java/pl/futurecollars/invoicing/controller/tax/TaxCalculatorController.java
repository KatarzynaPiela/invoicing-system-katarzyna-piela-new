package pl.futurecollars.invoicing.controller.tax;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.service.TaxCalculatorResult;
import pl.futurecollars.invoicing.service.TaxCalculatorService;

@RestController
@AllArgsConstructor
public class TaxCalculatorController implements TaxCalculatorApi {

  private final TaxCalculatorService taxService;

  @Override
  public TaxCalculatorResult calculateTaxes(@RequestBody Company company) {
    return taxService.calculateTaxes(company);
  }
}
