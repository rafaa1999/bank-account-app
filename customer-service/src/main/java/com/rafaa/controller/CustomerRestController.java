package com.rafaa.controller;

import com.rafaa.model.Customer;
import com.rafaa.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
   private CustomerRepository customerRepository;

   public CustomerRestController(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }

   @GetMapping("/customers")
   public List<Customer> customerList(){
       return customerRepository.findAll();
   }

   @GetMapping("/customer/{id}")
   public Customer customerById(@PathVariable Long id){
       return customerRepository.findById(id).get();
   }

}
