package com.rafaa.web;

import com.rafaa.clients.CustomerRestClient;
import com.rafaa.entities.BankAccount;
import com.rafaa.model.Customer;
import com.rafaa.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
   final private BankAccountRepository bankAccountRepository;
   final private CustomerRestClient customerRestClient;

   public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
       this.bankAccountRepository = bankAccountRepository;
       this.customerRestClient = customerRestClient;
   }

   @GetMapping("/accounts")
   public List<BankAccount> bankList(){
       List<BankAccount> accountList = bankAccountRepository.findAll();
       accountList.forEach(acc -> {
          acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
       });
       return accountList;
   }

   @GetMapping("/accounts/{id}")
   public BankAccount bankAccountById(@PathVariable String id){
      BankAccount bankAccount = bankAccountRepository.findById(id).get();
      Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
      bankAccount.setCustomer(customer);
      return bankAccount;
   }

}
