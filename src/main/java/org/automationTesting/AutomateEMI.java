package org.automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// EMI Automation class
public class AutomateEMI {
    // Define properties
    private double principal = 1000000;
    private double interestRate = 9.0;
    private int durationMonths = 84;

    // Launch browser and automate calculator
    public void runAutomation() {
        // Set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/emi-calculator.html"); // or your deployed URL
        driver.manage().window().maximize();

        try {
            // Input values to the webpage (Update IDs as per your HTML)
            WebElement amountInput = driver.findElement(By.id("loanamount"));
            WebElement interestInput = driver.findElement(By.id("interestrate"));
            WebElement monthsInput = driver.findElement(By.id("loanterm"));

            amountInput.clear();
            amountInput.sendKeys(String.valueOf(principal));

            interestInput.clear();
            interestInput.sendKeys(String.valueOf(interestRate));

            monthsInput.clear();
            monthsInput.sendKeys(String.valueOf(durationMonths));

            // Click calculate button
            WebElement calculateBtn = driver.findElement(By.id("calculateBtn"));
            calculateBtn.click();

            // Wait for output (can be enhanced with WebDriverWait)
            Thread.sleep(2000); // temporary pause

            // Extract results (Update IDs)
            String emi = driver.findElement(By.id("emi")).getText();
            String totalInterest = driver.findElement(By.id("totalinterest")).getText();
            String totalPayment = driver.findElement(By.id("totalpayment")).getText();

            // Print results
            System.out.println("========= RESULTS FROM WEBPAGE =========");
            System.out.println("EMI: ₹" + emi);
            System.out.println("Total Interest: ₹" + totalInterest);
            System.out.println("Total Payment: ₹" + totalPayment);
        } catch (Exception e) {
            System.out.println("Error during automation: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        AutomateEMI automation = new AutomateEMI();
        automation.runAutomation();
    }
}
