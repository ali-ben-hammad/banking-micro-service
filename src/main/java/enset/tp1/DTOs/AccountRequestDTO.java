package enset.tp1.DTOs;

import enset.tp1.entities.AccountType;
import lombok.Data;

@Data
public class AccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType accountType;
}
