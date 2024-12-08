package net.rhaz.accountservice;

import net.rhaz.accountservice.client.CustomerResetClient;
import net.rhaz.accountservice.entities.BankAccount;
import net.rhaz.accountservice.enums.AccountType;
import net.rhaz.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerResetClient customerResetClient) {
        return args -> {

                customerResetClient.allCustomers().forEach(

                        c -> {
                            BankAccount bankAccount1 = BankAccount.builder()
                                    .accountId(UUID.randomUUID().toString())
                                    .currency("MAD")
                                    .balance(80000)
                                    .createAt(LocalDate.now())
                                    .type(AccountType.CURRENT_ACCOUNT)
                                    .customerId(c.getId())
                                    .build();

                            BankAccount bankAccount2 = BankAccount.builder()
                                    .accountId(UUID.randomUUID().toString())
                                    .currency("MAD")
                                    .balance(30000)
                                    .createAt(LocalDate.now())
                                    .type(AccountType.CURRENT_ACCOUNT)
                                    .customerId(c.getId())
                                    .build();

                            accountRepository.save(bankAccount1);
                            accountRepository.save(bankAccount2);

                        }
                );




        };
    }
}
