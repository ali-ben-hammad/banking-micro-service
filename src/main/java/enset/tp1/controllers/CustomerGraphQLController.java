package enset.tp1.controllers;


import enset.tp1.entities.Customer;
import enset.tp1.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepo customerRepo;

    @QueryMapping
    public List<Customer> customersList(){
        return customerRepo.findAll();
    }
}
