package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final CustomerRepository customerRepository;

    @SneakyThrows
    public ResponseEntity<Customer> register(Customer customer) {
        customerRepository.save(customer);

        ResponseCookie springCookie = ResponseCookie.from("username", customer.getUsername())
                .httpOnly(true).secure(false)
                .path("/").maxAge(120)
                .domain("localhost").build();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).body(customer);
    }

    public ResponseEntity<Customer> login(Customer customer) {
        Optional<Customer> foundCustomer = customerRepository.findFirstByUsernameAndPassword(customer.getUsername(),
                customer.getPassword());

        if (foundCustomer.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            ResponseCookie springCookie = ResponseCookie.from("username", customer.getUsername())
                    .httpOnly(true).secure(false)
                    .path("/").maxAge(120)
                    .domain("localhost").build();
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).body(foundCustomer.get());
        }
    }
}