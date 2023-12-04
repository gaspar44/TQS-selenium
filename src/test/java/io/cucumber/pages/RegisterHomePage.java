package io.cucumber.pages;

import io.cucumber.sample.AbstractUser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterHomePage {

  public static final String EXPECTED_CREATION_TEXT = "ACCOUNT CREATED!";
  private static final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
  private static final String DATA_QA_SELECTOR_SUFFIX = "']";
  private static final String PASSWORD_FIELD = "password";
  private static final String FIRSTNAME_FIELD = "first_name";
  private static final String LASTNAME_FIELD = "last_name";
  private static final String ADDRESS_FIELD = "address";
  private static final String STATE_FIELD = "state";
  private static final String CITY_FIELD = "city";
  private static final String ZIP_CODE_FIELD = "zipcode";
  private static final String MOBILE_NUMBER_FIELD = "mobile_number";
  private static final String CREATE_ACCOUNT_BUTTON = "create-account";
  private static final String CREATED_ACCOUNT = "account-created" ;
  private static final String CONTINUE_BUTTON = "continue-button";

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + PASSWORD_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement passwordFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + FIRSTNAME_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement firstnameFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + LASTNAME_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement lastnameFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + ADDRESS_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement addressFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + STATE_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement stateFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CITY_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement cityFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + ZIP_CODE_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement zipcodeFieldText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + MOBILE_NUMBER_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement mobilePhoneFieldText;


  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CREATE_ACCOUNT_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement createAccountButton;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CREATED_ACCOUNT + DATA_QA_SELECTOR_SUFFIX)
  private WebElement createdAccountText;
  
  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CONTINUE_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement continueButton;


  private WebDriver driver;

  public RegisterHomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public String fillPage(AbstractUser user) throws Exception {
    passwordFieldText.sendKeys(user.getPassword());
    firstnameFieldText.sendKeys(user.getUserFirstname());
    lastnameFieldText.sendKeys(user.getUserLastname());
    addressFieldText.sendKeys(user.getAddress());
    stateFieldText.sendKeys(user.getState());
    cityFieldText.sendKeys(user.getCity());
    zipcodeFieldText.sendKeys(user.getZipCode());
    mobilePhoneFieldText.sendKeys(user.getPhone());
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
    createAccountButton.click();
    String obtianedText = createdAccountText.getText();
    continueButton.click();
    return obtianedText;
  }

  public void removeUser() throws Exception {

  }
  public void shutdown() {
    if (driver != null) {
      driver = null;
    }
  }
}
