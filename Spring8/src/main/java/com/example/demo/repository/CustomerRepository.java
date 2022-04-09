package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository <Customer, Integer>{
    List<Customer> findAllByUsernameAndCityAndCountry(String username, String city, String country);
    Optional<Customer> findFirstByUsernameAndPassword(String username, String password);
}
