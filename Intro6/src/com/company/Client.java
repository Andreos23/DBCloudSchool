package com.company;

import com.company.enums.PizzaType;
import com.company.pizza.Pizza;

import java.util.ArrayList;

public class Client {
    private Observer observer;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public void attachObserver(Observer observer){
        this.observer = observer;
    }

    public void notifyObserver(){
        observer.receiveUpdate();
    }

    public void orderPizza(PizzaCommand c, PizzaType pizzaType){
        System.out.println("Your order has been placed");
        c.execute(this, pizzaType);
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
}
