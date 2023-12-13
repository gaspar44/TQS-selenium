package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
  private static final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
  private static final String DATA_QA_SELECTOR_SUFFIX = "']";
  private static final String NAME_ON_CARD = "name-on-card";
  private static final String CARD_NUMBER = "card-number";
  private static final String CVC = "cvc";
  private static final String EXPIRATION_MONTH = "expiry_month";
  private static final String EXPIRATION_YEAR = "expiry-year";
  private static final String PAYMENT_BUTTON = "pay-button";

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


  public PaymentPage(WebDriver driver ) {
    PageFactory.initElements(driver, this);
  }
}
