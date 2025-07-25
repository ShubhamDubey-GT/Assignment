package org.assignment;

public class BankRunner {
    public static void main(String[] args) {
        BankingApp user1 = new BankingApp("Shubham", 5000);
        BankingApp user2 = new BankingApp("Divyansh", 10000);

        // Deposit - safe even with errors
        user1.deposit(2000);
        user1.deposit(-100);  // Will throw and catch IllegalArgumentException

        System.out.println("----------------------");

        // Withdraw - includes exception throwing
        try {
            user1.withdraw(1000);
            user1.withdraw(7000);  // Will throw custom InsufficientFundsException
        } catch (IllegalArgumentException e) {
            System.out.println("Withdraw Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Withdraw Error: " + e.getMessage());
        } finally {
            System.out.println("Withdrawal process for user1 completed.");
        }

        System.out.println("----------------------");

        // Check balance
        user1.checkBalance();
        user2.checkBalance();
    }
}
