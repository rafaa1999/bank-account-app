package com.rafaa;

import com.rafaa.entities.BankAccount;
import com.rafaa.enums.AccountType;
import com.rafaa.repository.BankAccountRepository;
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
        SpringApplication.run(AccountServiceApplication.class);
    }

   @Bean
   public CommandLineRunner runner(BankAccountRepository bankAccountRepository){
        return args -> {
            BankAccount bankAccount_one = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(4673)
                    .createAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            BankAccount bankAccount_two = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(34563)
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();

            bankAccountRepository.save(bankAccount_one);
            bankAccountRepository.save(bankAccount_two);
        };
   }
}