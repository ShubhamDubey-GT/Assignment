package org.assignment11;

import java.sql.*;
import java.io.FileOutputStream;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().browserVersion("139").setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Wait per step
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String excelPath = "LoginResults.xlsx";

        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT username, password FROM users");

            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Results");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Username");
            header.createCell(1).setCellValue("Password");
            header.createCell(2).setCellValue("Result");

            int rowNum = 1;

            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");

                driver.get("https://www.saucedemo.com/");

                // Username
                WebElement usernameField = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
                usernameField.clear();
                usernameField.sendKeys(user);

                // Password
                WebElement passwordField = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("password")));
                passwordField.clear();
                passwordField.sendKeys(pass);

                // Login button
                WebElement loginBtn = wait.until(
                        ExpectedConditions.elementToBeClickable(By.id("login-button")));
                loginBtn.click();

                String result;
                try {
                    // Wait for burger menu → login success
                    WebElement menuBtn = wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
                    result = "PASS";

                    // Logout sequence
                    menuBtn.click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();

                    // Wait for username field to reappear before next iteration
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

                } catch (TimeoutException te) {
                    // Login failed
                    result = "FAIL";

                    // Optional: wait a moment before retrying
                    Thread.sleep(1000);
                }

                // Write result to Excel
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user);
                row.createCell(1).setCellValue(pass);
                row.createCell(2).setCellValue(result);

                System.out.println(user + " | " + pass + " | " + result);
            }

            // Save Excel once after loop
            try (FileOutputStream out = new FileOutputStream(excelPath)) {
                wb.write(out);
            }
            wb.close();

            System.out.println("Test Results Written to Excel: " + excelPath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
