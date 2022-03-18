package com.company;

public class Bus extends Vehicle {
    private int noPassengers;
    private double ticketPrice;
    private double charge;

    public Bus(String colour, boolean functional, int noPassengers, double ticketPrice) {
        super(colour, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
        charge = 0;
    }

    @Override
    public void charge() {
        charge += ticketPrice;
    }

    @Override
    public double profit() {
        return 0.25 * charge;
    }

    @Override
    public void display() {
        System.out.println("Bus" + this);
    }

    public int getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "{" +
                "noPassengers=" + noPassengers +
                ", ticketPrice=" + ticketPrice +
                ", charge=" + charge +
                '}';
    }
}
