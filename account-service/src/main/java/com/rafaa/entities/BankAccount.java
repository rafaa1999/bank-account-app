package com.rafaa.entities;

import com.rafaa.enums.AccountType;
import com.rafaa.model.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
   @Id
   private String accountId;
   @NotNull
   @Positive
   private double balance;
   @NotNull
   private LocalDate createAt;
   @NotEmpty
   private String currency;
   @NotNull
   @Enumerated(EnumType.STRING)
   private AccountType type;
   @Transient
   private Customer customer;
   @NotNull
   private Long customerId;
}
