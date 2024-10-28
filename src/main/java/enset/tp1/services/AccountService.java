package enset.tp1.services;

import enset.tp1.DTOs.AccountRequestDTO;
import enset.tp1.DTOs.AccountResponseDTO;

public interface AccountService {
    public AccountResponseDTO addAccount(AccountRequestDTO accountDTO);
    public AccountResponseDTO updateAccount(String id, AccountRequestDTO accountDTO);
}
