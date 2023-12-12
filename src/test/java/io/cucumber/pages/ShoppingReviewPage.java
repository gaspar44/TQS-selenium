package io.cucumber.pages;

import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.DemoUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingReviewPage {
  @FindBy(xpath = "//ul[contains(@id, 'address_delivery')]//li")
  private List<WebElement> addressDelivery;

  @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
  private List<WebElement> addressInvoice;

  @FindBy(xpath = "//section/div/div[5]/table/tbody/tr[3]/td[4]/p")
  private WebElement totalAmount;

  @FindBy(css = "a[href='/payment']")
  private WebElement placeOrderButton;
  private WebDriver driver;

  public ShoppingReviewPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public AbstractUser getUserFromDeliveryAddress(String username, String email) {
    AbstractUser ret = new DemoUser(username, email);
    List<String> elements = addressDelivery.stream().map(WebElement::getText).collect(Collectors.toList());

    if (elements.size() != 8) {
      return null;
    }

    // The element order is TITLE
    // firstname + lastname
    // company name (empty in our scenarios)
    // address 1
    // address 2 (empty in our scenarios)
    // city + state + zipcode
    // country (empty in our scenarios)
    // mobile
    return ret;
  }
}
