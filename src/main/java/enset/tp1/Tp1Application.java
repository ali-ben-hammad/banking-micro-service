package enset.tp1;

import enset.tp1.entities.Account;
import enset.tp1.entities.AccountType;
import enset.tp1.repositories.AccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Tp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepo accountRepo){
        return args ->{
            for(int i=0; i<10; i++){
                Account account = Account.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                accountRepo.save(account);
            }
        };
    }

}
