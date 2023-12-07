package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductsPage {
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
  private WebDriver driver;
  public SearchProductsPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }
}
