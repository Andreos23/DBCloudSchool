package com.company;

import com.company.pizza.Pizza;

public class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
        System.out.println("Preparation has begun");
    }
}
