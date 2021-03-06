package com.example.spring4.services;

import com.example.spring4.model.Order;
import com.example.spring4.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getById(Integer id) {
        return orderRepository.getById(id);
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(orders::add);
        return orders;
    }

    public void insert(Order order) {
        orderRepository.save(order);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
