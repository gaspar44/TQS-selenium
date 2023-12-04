package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
    private final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
    private final String DATA_QA_SELECTOR_SUFFIX = "']";
    private WebDriver driver;

    @Given("My favorite {}")
    public void openBrowser(String browserName) throws Exception {
        WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
        driver = WebDriverFactory.getDriver(driverID);
        String baseUrl = "https://automationexercise.com/login";
        driver.get(baseUrl);
    }

    @When("I try to register with {} and {}")
    public void register(String name, String mail) {
        String signupButton = "signup-button";
        WebElement element = driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + signupButton + DATA_QA_SELECTOR_SUFFIX));

        String signupName = "signup-name";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + signupName + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(name);

        String signupMail = "signup-email";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + signupMail + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(mail);

        element.click();
    }

    @Then("I fill all the necessary data")
    public void fill() {
        String passwordField = "password";
        String password = "demodemo";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + passwordField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(password);

        String firstnameField = "first_name";
        String firstname = "John";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + firstnameField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(firstname);

        String lastnameField = "last_name";
        String lastname = "Smith";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + lastnameField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(lastname);

        String addressField = "address";
        String address = "Calle 1";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + addressField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(address);

        String stateField = "state";
        String state = "Barcelona";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + stateField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(state);

        String cityField = "city";
        String city = "Barcelona";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + cityField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(city);

        String zipCodeField = "zipcode";
        String zipCode = "01234";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + zipCodeField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(zipCode);

        String mobileNumberField = "mobile_number";
        String mobileNumber = "1234567";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + mobileNumberField + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(mobileNumber);

        String createAccountButton = "create-account";
        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + createAccountButton + DATA_QA_SELECTOR_SUFFIX))
            .click();

        String accountCreated = "account-created";
        String expected = driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + accountCreated + DATA_QA_SELECTOR_SUFFIX))
            .getText();

        Assertions.assertEquals(expected,"ACCOUNT CREATED!");

        driver.findElement(By.linkText("Delete account")).click();
    }

    @After
    public void shutdown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
