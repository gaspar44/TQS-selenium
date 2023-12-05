package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.LoggedPage;
import io.cucumber.pages.RegisterHomePage;
import io.cucumber.pages.RegisterOrLoginLandingPage;
import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.DemoUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class Register {
    private WebDriver driver;
    private AbstractUser demoUser;

    @Given("My favorite {}")
    public void openBrowser(String browserName) throws Exception {
        WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
        driver = WebDriverFactory.getDriver(driverID);
        String baseUrl = "https://automationexercise.com/login";
        driver.get(baseUrl);
    }

    @When("I try to register with {} and {}")
    public void register(String name, String mail) throws Exception {
        demoUser = new DemoUser(name, mail);
        RegisterOrLoginLandingPage homePage = new RegisterOrLoginLandingPage(driver);
        homePage.register(demoUser);
    }

    @And("I fill all the necessary data with the glorious {}")
    public void fill(String password) throws Exception {
        RegisterHomePage registerHomePage = new RegisterHomePage(driver);
        demoUser.setPassword(password);
        String createdUserText = registerHomePage.fillPage(demoUser);

        Assertions.assertEquals(RegisterHomePage.EXPECTED_CREATION_TEXT, createdUserText);

    }
    @Then("I remove the created account")
    public void delete() throws Exception {
        LoggedPage loggedPage = new LoggedPage(driver);
        String deletedUserPassword = loggedPage.deleteUser();
        Assertions.assertEquals(LoggedPage.EXPECTED_DELETE_TEXT, deletedUserPassword);
    }

    @After
    public void shutdown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
