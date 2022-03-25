package com.company;

import com.company.enums.PizzaType;

public class PizzaCommand {
    public PizzaCommand() {

    }

    public void execute (Client client, PizzaType pizzaType){
        client.addPizza(PizzaFactory.instance().createPizza(pizzaType));
    }
}
