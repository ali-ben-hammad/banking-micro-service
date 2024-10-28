package enset.tp1.controllers;

import enset.tp1.DTOs.AccountRequestDTO;
import enset.tp1.DTOs.AccountResponseDTO;
import enset.tp1.entities.Account;
import enset.tp1.mappers.AccountMapper;
import enset.tp1.repositories.AccountRepo;
import enset.tp1.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api")
public class AccountController {
    private AccountRepo accountRepo;
    private AccountService accountService;
    private AccountMapper accountMapper;

    @GetMapping("/accounts")
    public List<Account> accounts(){
        return accountRepo.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account account(@PathVariable String id){
        return accountRepo.findById(id).orElseThrow(()-> new RuntimeException(String.format("account not found")));
    }

    @PostMapping("/accounts")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO account){
//        if(account.getId()==null) account.setId(UUID.randomUUID().toString());
        return accountService.addAccount(account);
    }

    @PutMapping("/accounts/{id}")
    public Account save(@PathVariable String id,@RequestBody Account account){
        Account account1 = accountRepo.findById(id).orElseThrow();
        if(account.getBalance()!=null) account1.setBalance(account.getBalance());
        if(account.getCreatedAt()!=null )account1.setCreatedAt(new Date());
        if(account.getAccountType()!=null) account1.setAccountType(account.getAccountType());
        if(account.getCurrency()!=null) account1.setCurrency(account.getCurrency());
        return accountRepo.save(account);
    }

    @DeleteMapping("/account/{id}")
    public void delete(@RequestBody String id){
        accountRepo.deleteById(id);
    }
}
