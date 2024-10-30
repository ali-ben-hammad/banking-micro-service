package enset.tp1;

import enset.tp1.entities.Account;
import enset.tp1.entities.AccountType;
import enset.tp1.entities.Customer;
import enset.tp1.repositories.AccountRepo;
import enset.tp1.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepo accountRepo, CustomerRepo customerRepo){
        return args ->{
          Stream.of("Ali", "Mohamed", "Hassan", "Khalid", "Omar").forEach(name->{
              Customer customer = Customer.builder()
                      .name(name)
                      .build();
                customerRepo.save(customer);
            });

          customerRepo.findAll().forEach(customer -> {
              Stream.of("Current Account", "Saving Account").forEach(accountType->{
                  Account account = Account.builder()
                          .id(UUID.randomUUID().toString())
                          .accountType(accountType.equals("Current Account")? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                          .balance(Math.random()*90000)
                          .createdAt(new Date())
                          .currency("MAD")
                          .customer(customer)
                          .build();
                  accountRepo.save(account);
              });
            });
        };
    }

}
