package org.assignment4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestEMICalculator {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);
            int testCaseCount = 2;

            for (int i = 1; i <= testCaseCount; i++) {
                System.out.println("===== Test Case " + i + " =====");

                Double amount = Double.parseDouble(props.getProperty("amount" + i));
                Double interest = Double.parseDouble(props.getProperty("interestRate" + i));
                Integer duration = Integer.parseInt(props.getProperty("duration" + i));

                Double expectedEmi = Double.parseDouble(props.getProperty("expectedEmi" + i));
                Double expectedInterest = Double.parseDouble(props.getProperty("expectedInterest" + i));
                Double expectedTotal = Double.parseDouble(props.getProperty("expectedTotal" + i));

                EMICalcClass loan = new EMICalcClass();
                loan.setAmount(amount);
                loan.setInterestRate(interest);
                loan.setDurationMonths(duration);
                loan.calculateAll();

                double actualEmi = Math.round(loan.getEmi());
                double actualInterest = Math.round(loan.getTotalInterest());
                double actualTotal = Math.round(loan.getTotalPayableAmount());

                System.out.println(actualEmi == Math.round(expectedEmi) ? "✅ EMI Test Passed" : "❌ EMI Test Failed");
                System.out.println(actualInterest == Math.round(expectedInterest) ? "✅ Interest Test Passed" : "❌ Interest Test Failed");
                System.out.println(actualTotal == Math.round(expectedTotal) ? "✅ Total Payable Test Passed" : "❌ Total Payable Test Failed");
                System.out.println(); // spacer
            }

        } catch (IOException e) {
            System.out.println("❌ Failed to load config: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid number format: " + e.getMessage());
        }
    }
}
