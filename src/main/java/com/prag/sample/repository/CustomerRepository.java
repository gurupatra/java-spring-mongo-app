package com.prag.sample.repository;

import com.prag.sample.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String> {
}
