package org.assignment;

// Topic: Interface with static and default methods
interface Vehicle {
    void drive();

    default void fuelType() {
        System.out.println("Fuel type: Petrol/Diesel");
    }

    static void vehicleInfo() {
        System.out.println("All vehicles must follow traffic rules.");
    }
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Car is driving smoothly.");
    }

    public void fuelType() {
        System.out.println("Car runs on petrol.");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Bike is zipping through traffic.");
    }
}

public class TransportTest {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bike();

        vehicle1.drive();
        vehicle1.fuelType();

        vehicle2.drive();
        vehicle2.fuelType();

        Vehicle.vehicleInfo();
    }
}
