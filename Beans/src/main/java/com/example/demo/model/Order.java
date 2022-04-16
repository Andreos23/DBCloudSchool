package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Double price;
    private String productName;

    public void applyDiscount() {
        this.setPrice(0.75 * this.getPrice());
    }
}
