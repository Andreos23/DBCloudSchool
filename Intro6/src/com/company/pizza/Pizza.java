package com.company.pizza;

import com.company.enums.Topping;

import java.util.ArrayList;

public class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<>();

    public Pizza() {
        toppings.add(Topping.NO_TOPPING);
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
}
