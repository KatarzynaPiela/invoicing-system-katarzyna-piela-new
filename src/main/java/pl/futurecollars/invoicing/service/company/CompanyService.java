package pl.futurecollars.invoicing.service.company;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Company;

@Service
public class CompanyService {

  private final Database<Company> database;

  public CompanyService(Database<Company> database) {
    this.database = database;
  }

  public long save(Company company) {
    return database.save(company);
  }

  public Optional<Company> getById(long id) {
    return database.getById(id);
  }

  public List<Company> getAll() {
    return database.getAll();
  }

  public Optional<Company> update(long id, Company updatedCompany) {
    updatedCompany.setId(id); // just in case it was not set
    return database.update(id, updatedCompany);
  }

  public Optional<Company> delete(long id) {
    return database.delete(id);
  }

}

