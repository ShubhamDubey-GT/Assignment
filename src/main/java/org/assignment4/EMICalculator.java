package org.assignment4;
import java.util.Scanner;

public class EMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EMICalcClass loan = new EMICalcClass();

        System.out.print("Enter Loan Amount (₹): ");
        loan.setAmount(sc.nextDouble());

        System.out.print("Enter Annual Interest Rate (%): ");
        loan.setInterestRate(sc.nextDouble());

        System.out.print("Enter Loan Duration (in months): ");
        loan.setDurationMonths(sc.nextInt());

        // Calculate all remaining fields
        loan.calculateAll();

        // Display results
        System.out.println("\n -- Insights about your EMI --");
        System.out.printf("Principal Amount       : ₹%.2f\n", loan.getPrincipalAmount());
        System.out.printf("EMI (Monthly Payment)  : ₹%.2f\n", loan.getEmi());
        System.out.printf("Total Interest Payable : ₹%.2f\n", loan.getTotalInterest());
        System.out.printf("Total Amount Payable   : ₹%.2f\n", loan.getTotalPayableAmount());
    }
}
