package org.assignment9;

class AgeTooYoungException extends Exception {
    public AgeTooYoungException(String message) {
        super(message);
    }
}

public class CustomExceptionHandling {
    public static void main(String[] args) {
        try {
            registerVoter("Kavita", 15);
        } catch (AgeTooYoungException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    static void registerVoter(String name, int age) throws AgeTooYoungException {
        if (age < 18) {
            throw new AgeTooYoungException(name + " is too young to vote.");
        } else {
            System.out.println(name + " is registered to vote.");
        }
    }
}
