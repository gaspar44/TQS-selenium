package io.cucumber.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProductsOrAddToCarPage {
  public static final String SEARCHED_PRODUCTS = "SEARCHED PRODUCTS";
  @FindBy(id = "search_product")
  private WebElement searchProductBar;

  @FindBy(id = "submit_search")
  private WebElement submitButton;

  @FindBy(css = "a[data-product-id='1']")
  private WebElement addToCartButton1;

  @FindBy(css = "a[data-product-id='2']")
  private WebElement addToCartButton2;

  @FindBy(css = "button[data-dismiss='modal']")
  private WebElement continueShoppingButton;

  @FindBy(css = "a[href='/view_cart'] u")
  private WebElement viewCartButton;

  @FindBy(css = ".title.text-center")
  private WebElement titleTextCenter;

  @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
  private List<WebElement> searchResultsNames;

  private WebDriver driver;
  public SearchProductsOrAddToCarPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public String search(String category) {
    searchProductBar.sendKeys(category);
    submitButton.click();
    return titleTextCenter.getText();
  }

  public List<String> getProductsSearchNames() {
    return searchResultsNames
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  public void addProductsToCard() {
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));
    webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addToCartButton1)));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton1);
    addToCartButton1.click();

    webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueShoppingButton)));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueShoppingButton);
    continueShoppingButton.click();

    webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(addToCartButton2)));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton2);
    addToCartButton2.click();
    webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueShoppingButton)));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueShoppingButton);
    viewCartButton.click();
  }
}
