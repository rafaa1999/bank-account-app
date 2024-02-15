package com.rafaa.web;

import com.rafaa.entities.BankAccount;
import com.rafaa.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
   final private BankAccountRepository bankAccountRepository;

   public AccountRestController(BankAccountRepository bankAccountRepository) {
       this.bankAccountRepository = bankAccountRepository;
   }

   @GetMapping("/accounts")
   public List<BankAccount> bankList(){
       return bankAccountRepository.findAll();
   }

   @GetMapping("/accounts/{id}")
   public BankAccount bankAccountById(@PathVariable String id){
       return bankAccountRepository.findById(id).get();
   }
}
