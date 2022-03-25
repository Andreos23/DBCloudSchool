package com.company;

public class Observer {
    Client client;

    public Observer(Client client){
        this.client = client;
        this.client.attachObserver(this);
    }

    public void receiveUpdate() {
        System.out.println("Bon appetit!");
    }
}
