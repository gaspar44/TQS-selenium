package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.ContactUsPage;
import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.DemoUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ContactUs {
  private WebDriver driver;
  private ContactUsPage contactUsPage;
  private String obtainedMessage;

  @Given("Be the {}")
  public void openBrowser(String browserName) throws Exception {
    WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
    driver = WebDriverFactory.getDriver(driverID);
    String baseUrl = "https://automationexercise.com/contact_us";
    driver.get(baseUrl);
  }

  @When("I fill the contact us with {} and {}")
  public void fillContactUsForm(String name, String email) {
    AbstractUser user = new DemoUser(name, email);
    contactUsPage = new ContactUsPage(driver);
    contactUsPage.fillForm(user);
  }

  @And("I click the button")
  public void sendForm() {
    obtainedMessage = contactUsPage.sendForm();
  }

  @Then("I get a correct message")
  public void checkMessage() {
    Assertions.assertEquals(ContactUsPage.EXPECTED_MESSAGE, obtainedMessage);
  }

  @After
  public void shutdown() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
