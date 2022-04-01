package com.example.spring4.controllers;

import com.example.spring4.model.Order;
import com.example.spring4.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders(@RequestParam Integer customer_id) {
        List<Order> orders = orderService.getAllOrders();
        if (customer_id != null) {
            orders = orders.stream().filter(order -> order.getCustomer().getId().equals(customer_id)).collect(Collectors.toList());
        }

        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        orderService.insert(order);
        return order;
    }

    @PostMapping("/orders/update")
    public Order updateOrder(@RequestBody Order order) {
        orderService.update(order);
        return order;
    }

    @DeleteMapping("/orders/delete")
    public void deleteOrder(@RequestBody Order order) {
        orderService.delete(order);
    }
}
