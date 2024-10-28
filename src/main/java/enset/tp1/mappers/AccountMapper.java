package enset.tp1.mappers;

import enset.tp1.DTOs.AccountResponseDTO;
import enset.tp1.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountResponseDTO fromAccount(Account account){
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        BeanUtils.copyProperties(account, accountResponseDTO);
        return accountResponseDTO;
    }
}
