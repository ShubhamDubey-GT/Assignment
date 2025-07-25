package org.assignment;

// Topic: Final Keyword
class Constants {
    final int MAX_USERS = 100;

    final void printWelcome() {
        System.out.println("Welcome to the system!");
    }
}

class SubConstants extends Constants {
    // Uncommenting below will throw error due to final method
    // void printWelcome() {
    //     System.out.println("Override attempt!");
    // }
}

public class SysFinal {
    public static void main(String[] args) {
        Constants c = new Constants();
        c.printWelcome();
        System.out.println("Max Users allowed: " + c.MAX_USERS);

        // Uncommenting below will cause error due to final variable
        // c.MAX_USERS = 200;
    }
}

