package org.assignment;

// Exception Handling
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankingApp {
    private String customerName;
    private double balance;

    public BankingApp(String customerName, double initialDeposit) {
        this.customerName = customerName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }
            balance += amount;
            System.out.println(customerName + " deposited ₹" + amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error during deposit: " + e.getMessage());
        } finally {
            System.out.println("Deposit process ended.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient balance to withdraw ₹" + amount);
        }
        balance -= amount;
        System.out.println(customerName + " withdrew ₹" + amount);
    }

    public void checkBalance() {
        System.out.println(customerName + "'s Current Balance: ₹" + balance);
    }
}
