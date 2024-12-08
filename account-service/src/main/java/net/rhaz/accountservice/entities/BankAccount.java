package net.rhaz.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.rhaz.accountservice.enums.AccountType;
import net.rhaz.accountservice.model.Customer;
import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
@Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient //Anuler ce attribut, Car Customer existe dans la BD dans le microService custumer-service
    private Customer customer;
    //customerId qui va associer entre nos microservices
    private Long customerId;
}
