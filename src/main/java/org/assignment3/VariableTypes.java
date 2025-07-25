package org.assignment3;

public class VariableTypes {
    // Instance variable
    private int instanceVar = 10;
    // Static variable
    private static int staticVar = 20;
    // Final variable
    private final int FINAL_VAR = 30;

    // Method with local and parameter variables
    public void displayVariables(int paramVar) {
        int localVar = 40;
        instanceVar += paramVar;
        System.out.println("Instance Var: " + instanceVar);
        System.out.println("Static Var: " + staticVar);
        System.out.println("Final Var: " + FINAL_VAR);
        System.out.println("Local Var: " + localVar);
    }

    // Another method to modify instance variable
    public void updateInstance(int newValue) {
        if (newValue > 0) instanceVar = newValue;
        System.out.println("Updated Instance Var: " + instanceVar);
    }

    public static void main(String[] args) {
        VariableTypes obj = new VariableTypes();
        obj.displayVariables(15);
        obj.updateInstance(50);
        System.out.println("Static Var remains unchanged: " + staticVar);
        System.out.println("Exploring variable scopes and types.");
    }
}
