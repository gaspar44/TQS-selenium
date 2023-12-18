package io.cucumber.pages;

import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.CreditCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
  public static final String EXPECTED_ORDER_PLACEMENT = "ORDER PLACED!";
  private static final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
  private static final String DATA_QA_SELECTOR_SUFFIX = "']";
  private static final String NAME_ON_CARD = "name-on-card";
  private static final String ORDER_PLACED = "order-placed";
  private static final String CARD_NUMBER = "card-number";
  private static final String CVC = "cvc";
  private static final String EXPIRATION_MONTH = "expiry-month";
  private static final String EXPIRATION_YEAR = "expiry-year";
  private static final String PAYMENT_BUTTON = "pay-button";
  private static final String CONTINUE_BUTTON = "continue-button";

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + NAME_ON_CARD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement nameOnCardTextBox;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CARD_NUMBER + DATA_QA_SELECTOR_SUFFIX)
  private WebElement cardNumberTextBox;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CVC + DATA_QA_SELECTOR_SUFFIX)
  private WebElement cvcTextBox;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + EXPIRATION_MONTH + DATA_QA_SELECTOR_SUFFIX)
  private WebElement expirationMonthTextBox;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + EXPIRATION_YEAR + DATA_QA_SELECTOR_SUFFIX)
  private WebElement expirationYearTextBox;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + PAYMENT_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement paymentButton;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + ORDER_PLACED + DATA_QA_SELECTOR_SUFFIX)
  private WebElement orderPlacedText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CONTINUE_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement continueButton;


  public PaymentPage(WebDriver driver ) {
    PageFactory.initElements(driver, this);
  }

  public String fill(AbstractUser user) {
    CreditCard creditCard = user.getCard();
    nameOnCardTextBox.sendKeys(creditCard.getName());
    cardNumberTextBox.sendKeys(creditCard.getCardNumber());
    cvcTextBox.sendKeys(creditCard.getCvc());
    expirationMonthTextBox.sendKeys(creditCard.getExpirationMonth());
    expirationYearTextBox.sendKeys(creditCard.getExpirationYear());
    paymentButton.click();
    String obtainedText = orderPlacedText.getText();
    continueButton.click();
    return obtainedText;
  }
}
