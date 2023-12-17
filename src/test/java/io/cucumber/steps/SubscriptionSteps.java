package io.cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubscriptionSteps {
    private final String BASE_URL = "https://automationexercise.com/";
    private WebDriver driver;
    private AbstractUser user;

    @Given("I use {}")
    public void openBrowser(String browserName) throws Exception {
        WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
        driver = WebDriverFactory.getDriver(driverID);
        driver.get(BASE_URL);
    }
    
    @When("I scroll down to the footer")
    public void scrollDownToFooter() {
        // Implement scrolling logic using JavaScriptExecutor or other methods
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @And("I verify the presence of the text 'SUBSCRIPTION'")
    public void verifySubscriptionText() {
        WebElement subscriptionText = driver.findElement(By.xpath("//footer//*[contains(text(), 'SUBSCRIPTION')]"));
        assertTrue(subscriptionText.isDisplayed());
    }

    @And("I enter an email address and click on the arrow button")
    public void enterEmailAndClickButton() {
        WebElement emailInput = driver.findElement(By.id("subscription-email")); // Replace with actual element locator
        WebElement arrowButton = driver.findElement(By.id("subscription-submit")); // Replace with actual element locator

        emailInput.sendKeys(user.getEmail());
        arrowButton.click();
    }

    @Then("I verify the success message 'You have been successfully subscribed!' is visible")
    public void verifySuccessMessage() {
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'You have been successfully subscribed!')]"));
        assertTrue(successMessage.isDisplayed());
    }

    @After
    public void shutdown() {
        if (driver != null) {
        driver.quit();
        driver = null;
        }
    }
}
