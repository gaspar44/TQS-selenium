package io.cucumber.pages;

import io.cucumber.sample.AbstractUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterOrLoginLandingPage {
  private static final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
  private static final String DATA_QA_SELECTOR_SUFFIX = "']";
  private static final String SIGNUP_BUTTON = "signup-button";
  private static final String SIGNUP_NAME= "signup-name";
  private static final String SIGNUP_EMAIL = "signup-email";

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + SIGNUP_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement signupButton;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + SIGNUP_NAME + DATA_QA_SELECTOR_SUFFIX)
  private WebElement signupNameField;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + SIGNUP_EMAIL + DATA_QA_SELECTOR_SUFFIX)
  private WebElement signupEmailField;
  private WebDriver driver;
  public RegisterOrLoginLandingPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public void register(AbstractUser user) throws Exception {
    signupNameField.sendKeys(user.getUsername());
    signupEmailField.sendKeys(user.getEmail());
    signupButton.click();
  }
}
