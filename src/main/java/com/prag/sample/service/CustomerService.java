package com.prag.sample.service;

import com.prag.sample.model.Customer;
import com.prag.sample.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer addDomain(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomer(String customerId){
        return repository.findById(customerId).get();
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }

    public void deleteAll() {
        repository.deleteAll();
    }


    public Customer updateCustomer(Customer newCustomer, String customerId) {
        return repository.findById(customerId)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setEmail(newCustomer.getEmail());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(customerId);
                    return repository.save(newCustomer);
                });
    }
}
