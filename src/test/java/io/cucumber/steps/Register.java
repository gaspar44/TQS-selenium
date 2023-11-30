package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
    private final String BASE_URL = "https://automationexercise.com/";
    private final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
    private final String DATA_QA_SELECTOR_SUFFIX = "']";
    private final String SIGNUP_NAME = "signup-name";
    private final String SIGNUP_MAIL = "signup-mail";
    private final String SIGHUP_BUTTON = "signup-button";
    private WebDriver driver;

    @Given("My favorite {}")
    public void openBrowser(String browserName) throws Exception {
        WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
        driver = WebDriverFactory.getDriver(driverID);
        driver.get(BASE_URL);
    }

    @When("I try to register with {} and {}")
    public void register(String name, String mail) {
        WebElement element = driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + SIGHUP_BUTTON + DATA_QA_SELECTOR_SUFFIX));

        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + SIGNUP_NAME + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(name);

        driver.findElement(By.cssSelector(DATA_QA_SELECTOR_PREFIX + SIGNUP_MAIL + DATA_QA_SELECTOR_SUFFIX))
            .sendKeys(mail);

        element.click();

    }

    @Then("I fill all the necessary data")
    public void hungry() {
        System.out.println("I'm hungry");
    }

    @After
    public void shutdown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
