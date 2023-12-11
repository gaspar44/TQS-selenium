package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchProductsPage {
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
  public SearchProductsPage(WebDriver driver) {
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
}
