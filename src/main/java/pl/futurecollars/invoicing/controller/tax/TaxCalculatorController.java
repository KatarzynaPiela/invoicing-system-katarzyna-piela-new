package pl.futurecollars.invoicing.controller.tax;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.futurecollars.invoicing.service.TaxCalculatorResult;

@RestController
@AllArgsConstructor
public class TaxCalculatorController implements TaxCalculatorApi {

  private final TaxCalculatorController taxService;

  @Override
  public TaxCalculatorResult calculateTaxes(String taxIdentificationNumber) {
    return taxService.calculateTaxes(taxIdentificationNumber);
  }
}
