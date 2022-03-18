package com.company;

public abstract class Vehicle implements Comparable<Vehicle> {
    private String colour;
    private boolean functional;

    public Vehicle() {
    }

    public Vehicle(String colour, boolean functional) {
        this.colour = colour;
        this.functional = functional;
    }

    abstract public void charge();

    abstract public double profit();

    abstract public void display();

    @Override
    public int compareTo(Vehicle o) {
        return Double.compare(this.profit(), o.profit());
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }
}
