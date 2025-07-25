package org.assignment3;

interface MathOperation {
    int operate(int a, int b);
}

public class LambdaExpression {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> {
            System.out.println("Adding " + a + " and " + b);
            return a + b;
        };
        MathOperation multiply = (a, b) -> {
            System.out.println("Multiplying " + a + " and " + b);
            return a * b;
        };
        MathOperation subtract = (a, b) -> {
            System.out.println("Subtracting " + b + " from " + a);
            return a - b;
        };
        System.out.println("Addition: " + add.operate(5, 3));
        System.out.println("Multiplication: " + multiply.operate(5, 3));
        System.out.println("Subtraction: " + subtract.operate(5, 3));
        System.out.println("Lambda expressions for functional programming.");
    }
}
