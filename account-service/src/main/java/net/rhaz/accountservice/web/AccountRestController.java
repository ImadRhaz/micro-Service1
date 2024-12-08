package net.rhaz.accountservice.web;

import net.rhaz.accountservice.client.CustomerResetClient;
import net.rhaz.accountservice.entities.BankAccount;
import net.rhaz.accountservice.model.Customer;
import net.rhaz.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;
    private  CustomerResetClient customerResetClient;

    public AccountRestController(BankAccountRepository accountRepository, CustomerResetClient customerResetClient) {
        this.accountRepository = accountRepository;
        this.customerResetClient = customerResetClient;
    }




    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(acc->{

            acc.setCustomer(customerResetClient.findCustomereById(acc.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount  bankAccount=accountRepository.findById(id).get(); // dans cette Bd
      Customer customer=customerResetClient.findCustomereById(bankAccount.getCustomerId());// chercher dans la bd de customerServicebankAccount.setCustomer(customer);
    bankAccount.setCustomer(customer);
     return bankAccount;
    }
}