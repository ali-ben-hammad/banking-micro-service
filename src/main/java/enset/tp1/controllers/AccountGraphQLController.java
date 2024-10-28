package enset.tp1.controllers;

import enset.tp1.repositories.AccountRepo;
import enset.tp1.DTOs.AccountRequestDTO;
import enset.tp1.DTOs.AccountResponseDTO;
import enset.tp1.services.AccountService;
import enset.tp1.entities.Account;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountGraphQLController {
    private AccountRepo accountRepo;
    private AccountService accountService;

    @QueryMapping
    public List<Account> accountsList(){
        return accountRepo.findAll();
    }

    @QueryMapping
    public Account accountById(@Argument String id){
        return accountRepo.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public AccountResponseDTO addAccount(@Argument AccountRequestDTO account){
        return accountService.addAccount(account);

    }

    @MutationMapping
    public AccountResponseDTO update(@Argument String id, @Argument AccountRequestDTO account){
        return accountService.updateAccount(id, account);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        accountRepo.deleteById(id);
        return true;
    }
}

//@Data
//@NoArgsConstructor @AllArgsConstructor
//class AccountDTO{
//    private String type;
//    private Double balance;
//    private String currency;
//}

//record AccountDTO(Double balance, String accountType, String currency){
//
//}
