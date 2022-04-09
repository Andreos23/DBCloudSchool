package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) {
        return authService.register(customer);
    }

    @PostMapping("login")
    public ResponseEntity<Customer> login(@RequestBody Customer customer) {
        return authService.login(customer);
    }
}