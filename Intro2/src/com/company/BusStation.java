package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class BusStation {
    private ArrayList<Vehicle> vehicles;

    public BusStation(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void showAllVehicles() {
        for (Vehicle vehicle: vehicles) {
            vehicle.display();
        }
    }

    public void showTotalProfit() {
        double profit = 0.0;
        for (Vehicle vehicle: vehicles) {
            profit += vehicle.profit();
        }

        System.out.println("Profit is " + profit);
    }

    public void sortVehicles() {
        Collections.sort(vehicles);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
