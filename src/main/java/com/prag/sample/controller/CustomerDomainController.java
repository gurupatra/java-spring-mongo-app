package com.prag.sample.controller;

import com.prag.sample.model.Customer;
import com.prag.sample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.prag.sample.Application.USER_COUNT;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
@Slf4j
public class CustomerDomainController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    List<Customer> getCustomers() {
        log.info("Finding all the customer entities ");
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{customer_id}")
    Customer getCustomer(@PathVariable String customer_id) {
        log.info("Finding the domain entity " + customer_id);
        return customerService.getCustomer(customer_id);
    }

    @PostMapping("/customer")
    Customer addCustomer(@RequestBody Customer customer) {
        log.info("Adding the domain entity ");
        return customerService.addDomain(customer);
    }

    @DeleteMapping("/customer/{customer_id}")
    void deleteCustomer(@PathVariable String customer_id) {
        log.info("Finding the domain entity " + customer_id);
        customerService.deleteCustomer(customer_id);
    }

    @DeleteMapping("/customers")
    void deleteAll() {
        log.info("Deleting all the the domain entities ");
        customerService.deleteAll();
    }


    @PutMapping("/customer/{customer_id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable String customer_id) {
        log.info("Updating the domain entity " + customer_id);
        return customerService.updateCustomer(newCustomer, customer_id);
    }


    @GetMapping("healthCheck")
    ResponseEntity<?> healthCheck() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello" + USER_COUNT);
    }
}
