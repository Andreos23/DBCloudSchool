package com.company;

import com.company.enums.PizzaType;
import com.company.pizza.*;

public class PizzaFactory {

    private static PizzaFactory pizzaFactoryInstance;

    private PizzaFactory() {}

    public static PizzaFactory instance() {
        if (pizzaFactoryInstance == null) {
            pizzaFactoryInstance = new PizzaFactory();
        }

        return pizzaFactoryInstance;
    }

    public Pizza createPizza(PizzaType type) {
        return switch (type) {
            case CAPRICIOSA -> new Capriciosa();
            case PROSCIUTTO_FUNGHI -> new ProsciuttoFunghi();
            case QUATRO_STAGIONI -> new QuatroStagioni();
            case MARGUERITA -> new Marguerita();
        };
    }
}
