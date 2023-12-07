package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchProductsStep {

  private WebDriver driver;
  @Given("The {} that I use for search products")
  public void openBrowser(String browserName) throws Exception {
    WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
    driver = WebDriverFactory.getDriver(driverID);
    driver.get("https://automationexercise.com/products");
  }

  @When("I add the first two products to the car.")
  public void addProducts() {
    // TODO
  }

  @Then("I check the car.")
  public void checkCar() {
    // TODO
  }

  @After
  public void shutdown() {
    if (driver != null ) {
      driver.quit();
      driver = null;
    }
  }
}
