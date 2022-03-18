package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Taxi("red", true, 3, 8.0));
        vehicles.add(new Bus("red", true, 3, 2.0));
        vehicles.add(new Bus("blue", false, 5, 2.5));
        vehicles.add(new Bus("green", true, 2, 3.0));
        vehicles.add(new Taxi("blue", false, 5, 9.0));
        vehicles.add(new Taxi("green", false, 2, 10.0));

        for (Vehicle vehicle: vehicles)
            vehicle.charge();
        vehicles.get(0).charge();
        vehicles.get(5).charge();

        BusStation busStation = new BusStation(vehicles);
        busStation.showAllVehicles();
        busStation.showTotalProfit();
        busStation.sortVehicles();
        busStation.showAllVehicles();
    }
}
