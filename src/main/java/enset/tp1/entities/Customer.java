package enset.tp1.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Customer{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

}
