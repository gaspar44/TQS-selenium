package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
  }
}
