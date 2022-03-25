package com.company;

import com.company.enums.PizzaType;

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        client.attachObserver(new Observer(client));
        client.orderPizza(new PizzaCommand(), PizzaType.CAPRICIOSA);
        client.orderPizza(new PizzaCommand(), PizzaType.MARGUERITA);
        client.orderPizza(new PizzaCommand(), PizzaType.QUATRO_STAGIONI);
        client.orderPizza(new PizzaCommand(), PizzaType.PROSCIUTTO_FUNGHI);
        client.notifyObserver();
    }
}
