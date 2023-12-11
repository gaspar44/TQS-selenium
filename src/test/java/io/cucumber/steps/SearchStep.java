package io.cucumber.steps;

import io.cucumber.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.SearchProductsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchStep {
  private WebDriver driver;
  SearchProductsPage searchProductsPage;

  @Given("I use {} for search products")
  public void openBrowser(String browserName) throws Exception {
    WebDriverFactory.DriverID driverID = WebDriverFactory.DriverID.valueOf(browserName);
    driver = WebDriverFactory.getDriver(driverID);
    driver.get("https://automationexercise.com/products");
  }

  @When("I type a {}.")
  public void search(String category) throws Exception {
    searchProductsPage = new SearchProductsPage(driver);
    String searchTextBarContent = searchProductsPage.search(category);
    Assertions.assertEquals(SearchProductsPage.SEARCHED_PRODUCTS, searchTextBarContent);
  }

  @Then("I see a {} result.")
  public void searchedProducts(String category) {
    List<String> results = searchProductsPage.getProductsSearchNames();
    results.forEach(result -> {
      Assertions.assertTrue(result.contains(category));
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
