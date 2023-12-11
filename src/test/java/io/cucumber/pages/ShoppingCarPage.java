package io.cucumber.pages;

import io.cucumber.sample.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCarPage {
  @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
  List<WebElement> productsDescriptions;

  @FindBy(xpath = "//td[contains(@class, 'cart_price')]/p")
  private List<WebElement> productsPrices;

  @FindBy(xpath = "//td[contains(@class, 'cart_quantity')]/button")
  private List<WebElement> productsQuantities;

  @FindBy(xpath = "//p[contains(@class, 'cart_total_price')]")
  private List<WebElement> totalPrice;

  List<Product> products;

  public ShoppingCarPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.products = new ArrayList<>();
    // All should be the same size
    for(int i = 0; i < productsQuantities.size(); i++){
      products.add(new Product(
          productsDescriptions.get(i).getText(),
          productsPrices.get(i).getText(),
          productsQuantities.get(i).getText()
      ));
    }
  }

  public List<Product> getProducts() {
    return this.products;
  }
}
