package org.assignment12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assignment12.utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RentalFormTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().browserVersion("139").setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebUtils utils = new WebUtils(driver, wait);
        final String FORM_URL = "https://www.mycontactform.com/samples/rental.php";
        String[][] scenarios = {
                {"Submit without entering anything", "error"},
                {"Missing First Name", "error"},
                {"Missing Last Name", "error"},
                {"Missing Email", "error"},
                {"Missing Phone Number", "error"},
                {"Missing Preferred Contact Method", "error"},
                {"Missing Preferred Contact Time", "error"},
                {"Missing Preferred Area", "error"},
                {"All fields filled correctly", "Thank you"}
        };
        try {
            for (String[] scenarioData : scenarios) {
                String scenario = scenarioData[0];
                String expectedMessage = scenarioData[1];
                System.out.println("--- Running Scenario: " + scenario + " ---");
                driver.get(FORM_URL);
                if (!scenario.equals("Submit without entering anything")) {
                    fillAllFields(utils);
                }
                switch (scenario) {
                    case "Missing First Name":
                        utils.clearField(By.name("q[1]"));
                        break;
                    case "Missing Last Name":
                        utils.clearField(By.name("q[2]"));
                        break;
                    case "Missing Email":
                        utils.clearField(By.name("email"));
                        break;
                    case "Missing Phone Number":
                        utils.clearField(By.name("q[3]"));
                        break;
                    case "Missing Preferred Contact Method":
                        utils.unclickRadio(By.name("q[4]"));
                        break;
                    case "Missing Preferred Contact Time":
                        utils.unclickRadio(By.name("q[5]"));
                        break;
                    case "Missing Preferred Area":
                        utils.clearField(By.name("q[11]"));
                        break;
                    default:
                        break;
                }
                utils.clickButton(By.name("submit"));
                handleSubmissionResult(utils, expectedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void fillAllFields(WebUtils utils) {
        utils.sendKeys(By.name("q[1]"), "John");
        utils.sendKeys(By.name("q[2]"), "Doe");
        utils.sendKeys(By.name("email"), "test@example.com");
        utils.sendKeys(By.name("q[3]"), "9876543210");
        utils.sendKeys(By.name("q[11]"), "Downtown");
        utils.clickButton(By.xpath("//input[@name='q[4]' and @value='Phone']"));
        utils.clickButton(By.xpath("//input[@name='q[5]' and @value='Morning']"));
        utils.clickButton(By.xpath("//input[@name='q[15]' and @value='No']"));
    }

    public static void handleSubmissionResult(WebUtils utils, String expectedMessage) {
        String result;
        try {
            if (expectedMessage.equals("error")) {
                utils.waitForVisibilityOfElement(By.xpath("//*[@id='content']/ul/li"));
                result = "PASS - Expected " + expectedMessage + " message was found.";
            } else {
                utils.waitForVisibilityOfElement(By.xpath("//*[@id='center_col']/h4"));
                result = "PASS - Expected " + expectedMessage + " message was found.";
            }
        } catch (TimeoutException e) {
            result = "FAIL - Expected " + expectedMessage + " message was not found.";
        }
        System.out.println("Result: " + result + "\n");
    }
}