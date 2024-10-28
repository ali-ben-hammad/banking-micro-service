package enset.tp1;

import enset.tp1.entities.Account;
import enset.tp1.entities.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Account.class, name="p1")
public interface AccountProjection {
    String getId();
    AccountType getType();
    Double getBalance();
}
