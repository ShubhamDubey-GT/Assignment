package org.assignment2;

/*
Create a class Calculator that has methods:
 - add(int a, int b)
 - subtract(int a, int b)
 - subtract(int a, int b
 - divide(int a, int b)
 */

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero");
            return 0;
        }
        return (double) a / b;
    }
}

// Main class for Calculator
public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Addition (5+3): " + calc.add(5, 3));
        System.out.println("Subtraction (5-3): " + calc.subtract(5, 3));
        System.out.println("Division (10/2): " + calc.divide(10, 2));
        System.out.println("Division (10/0): " + calc.divide(10, 0));
    }
}
