package com.rafaa;

import com.rafaa.model.Customer;
import com.rafaa.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
       SpringApplication.run(CustomerServiceApplication.class);
    }

   @Bean
   public CommandLineRunner runner(CustomerRepository customerRepository){
        return args -> {

            List<Customer> customers = List.of(
                    Customer.builder()
                            .firstName("fin")
                            .LastName("yakov")
                            .email("fin@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("fin")
                            .LastName("yakov")
                            .email("fin@gmail.com")
                            .build()
            );

           customerRepository.saveAll(customers);

        };
   }

}