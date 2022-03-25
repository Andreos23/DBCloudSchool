package com.company.pizza;

import com.company.ToppingDecorator;
import com.company.enums.Topping;

public class ProsciuttoFunghi extends Pizza {
    public ProsciuttoFunghi() {
        super();
        toppings.clear();
        toppings.add(Topping.MOZZARELLA);
        toppings.add(Topping.TOMATOES);
        toppings.add(Topping.PROSCIUTTO);
        toppings.add(Topping.MUSHROOMS);
        new ToppingDecorator(this);
    }
}
