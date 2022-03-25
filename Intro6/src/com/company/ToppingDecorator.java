package com.company;

import com.company.enums.Topping;
import com.company.pizza.Pizza;

public class ToppingDecorator extends PizzaDecorator {
    public ToppingDecorator(Pizza pizza) {
        super(pizza);
        for (Topping topping : pizza.getToppings()) {
            System.out.println(topping.toString() + " has been added");
        }

        System.out.println("Topping Process Finished!\n\n");
    }
}
