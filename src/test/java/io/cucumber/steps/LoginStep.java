package io.cucumber.steps;

import io.cucumber.UIHelper;
import io.cucumber.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.LoggedPage;
import io.cucumber.pages.RegisterOrLoginLandingPage;
import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.DemoUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginStep {
  private WebDriver driver;
  private AbstractUser user;

  @Given("The {}. I register with {}, {} and {}")
  public void openBrowser(String browserName, String name, String email, String password) throws Exception {
    WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
    driver = WebDriverFactory.getDriver(driverID);
    String baseUrl = "https://automationexercise.com/login";
    driver.get(baseUrl);

    user = new DemoUser(name, email);
    user.setPassword(password);

    UIHelper.registerUser(driver, user);
    LoggedPage loggedPage = new LoggedPage(driver);
    loggedPage.logout();
  }

  @When("I try to login with {}, {} and the the glorious {}")
  public void registerAndLogin(String email, String name, String password) throws Exception {
    RegisterOrLoginLandingPage homePage = new RegisterOrLoginLandingPage(driver);
    user = new DemoUser(name, email);
    user.setPassword(password);
    homePage.login(user);
    LoggedPage loggedPage = new LoggedPage(driver);
    Assertions.assertEquals(user.getUsername(),loggedPage.getUsername());
  }

  @Then("I remove the logged account")
  public void removeAccount() throws Exception {
    LoggedPage loggedPage = new LoggedPage(driver);
    String deletedUserPassword = loggedPage.deleteUser();
    Assertions.assertEquals(LoggedPage.EXPECTED_DELETE_TEXT, deletedUserPassword);
  }
}
