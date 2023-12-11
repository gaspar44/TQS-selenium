package io.cucumber.steps;

import io.cucumber.UIHelper;
import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.SearchProductsOrAddToCarPage;
import io.cucumber.pages.ShoppingCarPage;
import io.cucumber.pages.ShoppingReviewPage;
import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.DemoUser;
import org.openqa.selenium.WebDriver;

public class PaymentStep {
  private final String BASE_URL = "https://automationexercise.com/";
  private WebDriver driver;
  private AbstractUser user;

  @Given("How I like {} for paying.")
  public void openBrowser(String browserName) throws Exception {
    WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
    driver = WebDriverFactory.getDriver(driverID);
    driver.get(BASE_URL + "/login");
  }

  @When("I try to pay with my {} and {}")
  public void registerUser(String email, String password) throws Exception {
    user = new DemoUser("josh", email);
    user.setPassword(password);
    UIHelper.registerUser(driver, user);
  }

  @And("I add basic products to the car.")
  public void addProductsToCar() {
    driver.get(BASE_URL + "/products");
    SearchProductsOrAddToCarPage productsPage = new SearchProductsOrAddToCarPage(driver);
    productsPage.addProductsToCard();
  }

  @And("I try to pay.")
  public void purchase() {
    ShoppingCarPage carPage = new ShoppingCarPage(driver);
    ShoppingReviewPage reviewPage = carPage.proceed();
  }
  @Then("I finish.")
  public void remove() throws Exception {
    UIHelper.removeUser(driver);
  }

  @After
  public void shutdown() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
