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
  private List<WebElement> deliveryAddress;

  @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
  private List<WebElement> invoiceAddress;

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
    List<String> elements = deliveryAddress.stream().map(WebElement::getText).collect(Collectors.toList());
    return createUserFromAddress(username, email, elements);
  }

  public AbstractUser getUserFromInvoiceAddress(String username, String email) {
    List<String> elements = invoiceAddress.stream().map(WebElement::getText).collect(Collectors.toList());
    return createUserFromAddress(username, email, elements);
  }

  private AbstractUser createUserFromAddress(String username, String email, List<String> elements) {
    AbstractUser ret = new DemoUser(username, email);

    if (elements.size() != 8) {
      return null;
    }

    // The element order is TITLE
    // . firstname + lastname
    // company name (empty in our scenarios)
    // address 1
    // address 2 (empty in our scenarios)
    // city + state + zipcode
    // country (empty in our scenarios)
    // mobile

    String[] names = elements.get(1).split(" ");
    ret.setUserFirstname(names[1]);
    ret.setUserLastname(names[2]);

    ret.setAddress(elements.get(3));

    String[] cityStateZipCode = elements.get(5).split(" ");
    ret.setCity(cityStateZipCode[0]);
    ret.setState(cityStateZipCode[1]);
    ret.setZipCode(cityStateZipCode[2]);

    ret.setPhone(elements.get(7));
    return ret;
  }
}
