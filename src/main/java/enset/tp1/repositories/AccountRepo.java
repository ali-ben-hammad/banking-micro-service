package enset.tp1.repositories;

import enset.tp1.entities.Account;
import enset.tp1.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AccountRepo extends JpaRepository<Account, String> {
    List<Account> findAccountByCurrency(String currency);
    @RestResource(path= "/byType")
    List<Account> findAccountByAccountType(@Param("t") AccountType type);
}
