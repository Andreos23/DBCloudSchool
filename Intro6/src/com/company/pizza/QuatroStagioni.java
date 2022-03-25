package com.company.pizza;

import com.company.ToppingDecorator;
import com.company.enums.Topping;

public class QuatroStagioni extends Pizza {
    public QuatroStagioni() {
        super();
        toppings.clear();
        toppings.add(Topping.MOZZARELLA);
        toppings.add(Topping.TOMATOES);
        toppings.add(Topping.BACON);
        toppings.add(Topping.MUSHROOMS);
        toppings.add(Topping.OLIVES);
        new ToppingDecorator(this);
    }
}
