package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.SearchProductsOrAddToCarPage;
import io.cucumber.pages.ShoppingCarPage;
import io.cucumber.sample.Product;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductsStep {

  private WebDriver driver;
  @Given("The {} that I use for buying products")
  public void openBrowser(String browserName) throws Exception {
    WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
    driver = WebDriverFactory.getDriver(driverID);
    driver.get("https://automationexercise.com/products");
  }

  @When("I add the first two products to the car.")
  public void addProducts() {
    SearchProductsOrAddToCarPage searchProductsOrAddToCarPage = new SearchProductsOrAddToCarPage(driver);
    searchProductsOrAddToCarPage.addProductsToCard();
  }

  @Then("I check the car.")
  public void checkCar() {
    ShoppingCarPage shoppingCarPage = new ShoppingCarPage(driver);
    List<Product> products = shoppingCarPage.getProducts();
    Assertions.assertNotEquals(0, products.size());

    products.forEach(product -> {
      Assertions.assertNotNull(product.getDescription());
      Assertions.assertTrue(product.getPrice() > 0);
      Assertions.assertTrue(product.getQuantities() > 0);
    });
  }

  @After
  public void shutdown() {
    if (driver != null ) {
      driver.quit();
      driver = null;
    }
  }
}
