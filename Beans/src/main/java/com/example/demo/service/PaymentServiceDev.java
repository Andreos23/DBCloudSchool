package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceDev implements PaymentService {
    private final PaymentRepository paymentRepository;

    public void test() {
        System.out.println("Payment service dev");
    }

    public Order createOrder(Order order) {
        System.out.println("Create order in dev");
        paymentRepository.save(order);
        return order;
    }
}
