package com.company.pizza;

import com.company.ToppingDecorator;
import com.company.enums.Topping;

public class Capriciosa extends Pizza {
    public Capriciosa() {
        super();
        toppings.clear();
        toppings.add(Topping.MOZZARELLA);
        toppings.add(Topping.BACON);
        toppings.add(Topping.TOMATOES);
        new ToppingDecorator(this);
    }
}