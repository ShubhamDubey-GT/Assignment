package org.assignment3;

abstract class Shape {
    abstract double calculateArea();
    public void display() {
        System.out.println("This is a shape with some common behavior.");
    }
    protected double getDefaultValue() { return 1.0; }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) { this.radius = radius; }
    double calculateArea() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    double calculateArea() { return length * width; }
}

public class Abstraction {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 6);
        c.display();
        System.out.println("Circle Area: " + c.calculateArea());
        r.display();
        System.out.println("Rectangle Area: " + r.calculateArea());
        System.out.println("Abstraction hides implementation details.");
    }
}
