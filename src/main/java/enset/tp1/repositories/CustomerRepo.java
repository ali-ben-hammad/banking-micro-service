package enset.tp1.repositories;

import enset.tp1.entities.Account;
import enset.tp1.entities.AccountType;
import enset.tp1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
