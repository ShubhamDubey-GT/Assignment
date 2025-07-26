package org.assignment2;

/*
Create a class BankAccount with methods to:
- Deposit
- Withdraw
- Check balance
- Initialize with a constructor and simulate a few transactions.
 */

class BankAccount {
    private double balance;
    private String accountHolder;

    // Constructor
    BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }

    void checkBalance() {
        System.out.println("Current balance for " + accountHolder + ": ₹" + balance);
    }
}

// Main class for BankAccount
public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Shubham Dubey", 1000.0);
        account.checkBalance();
        account.deposit(500.0);
        account.checkBalance();
        account.withdraw(200.0);
        account.checkBalance();
        account.withdraw(2000.0);
        account.checkBalance();
    }
}
