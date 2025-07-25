package org.assignment3;

abstract class Vehicle {
    abstract void start();
    abstract void stop();
    protected String model;

    public Vehicle(String model) { this.model = model; }
    public void displayModel() { System.out.println("Model: " + model); }
}

class Car extends Vehicle {
    public Car(String model) { super(model); }
    void start() { System.out.println("Car engine started."); }
    void stop() { System.out.println("Car stopped."); }
}

class Bike extends Vehicle {
    public Bike(String model) { super(model); }
    void start() { System.out.println("Bike engine started."); }
    void stop() { System.out.println("Bike stopped."); }
}

public class AbstractClass {
    public static void main(String[] args) {
        Vehicle c = new Car("Toyota");
        Vehicle b = new Bike("Honda");
        c.start();
        c.stop();
        c.displayModel();
        b.start();
        b.stop();
        b.displayModel();
        System.out.println("Abstract class with multiple implementations.");
    }
}
