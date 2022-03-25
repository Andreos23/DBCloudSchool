package com.company.pizza;

import com.company.ToppingDecorator;
import com.company.enums.Topping;

public class Marguerita extends Pizza {

    public Marguerita() {
        super();
        toppings.clear();
        toppings.add(Topping.MOZZARELLA);
        toppings.add(Topping.TOMATOES);
        new ToppingDecorator(this);
    }
}
