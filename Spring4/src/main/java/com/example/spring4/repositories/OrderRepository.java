package com.example.spring4.repositories;

import com.example.spring4.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    public Order getById(Integer id);
}
