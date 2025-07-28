package org.assignment4;

class EMICalcClass {
    private double amount;                 // Input amount (Principal)
    private double interestRate;          // Annual interest rate
    private int durationMonths;           // Loan duration in months
    private double principalAmount;       // Computed (same as amount)
    private double emi;                   // Computed EMI
    private double totalInterest;         // Computed total interest
    private double totalPayableAmount;    // Computed total payment

    // Setters
    void setAmount(double amount) {
        this.amount = amount;
        this.principalAmount = amount; // For display
    }
    void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }
    // Getters
    double getAmount() {
        return amount;
    }
    double getInterestRate() {
        return interestRate;
    }
    int getDurationMonths() {
        return durationMonths;
    }
    double getPrincipalAmount() {
        return principalAmount;
    }
    double getEmi() {
        return emi;
    }
    double getTotalInterest() {
        return totalInterest;
    }
    double getTotalPayableAmount() {
        return totalPayableAmount;
    }
    void calculateAll() {  // Logical Stuffs / Calculation
        double monthlyRate = interestRate / 12 / 100;
        int n = durationMonths;

        emi = (amount * monthlyRate * Math.pow(1 + monthlyRate, n)) /
                (Math.pow(1 + monthlyRate, n) - 1);

        totalPayableAmount = emi * durationMonths;
        totalInterest = totalPayableAmount - amount;
    }
}
