package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Company {

  @ApiModelProperty(value = "Tax Identification number", required = true, example = "101-133-111-10")
  private String taxIdentificationNumber;

  @ApiModelProperty(value = "Company address", required = true, example = "ul. Pstrągowa 24;  91-859 Szczecin")
  private String address;

  @ApiModelProperty(value = "Company name", required = true, example = "Medical.sp. z o. o.")
  private String name;

  public Company(String taxIdentificationNumber, String address, String name) {
    this.taxIdentificationNumber = taxIdentificationNumber;
    this.address = address;
    this.name = name;
  }

}

