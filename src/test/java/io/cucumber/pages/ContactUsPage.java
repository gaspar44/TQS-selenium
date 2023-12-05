package io.cucumber.pages;

import io.cucumber.sample.AbstractUser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
  public static final String EXPECTED_MESSAGE = "Success! Your details have been submitted successfully.";
  private static final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
  private static final String DATA_QA_SELECTOR_SUFFIX = "']";
  private static final String NAME_FORM = "name";
  private static final String EMAIL_FORM = "email";
  private static final String SUBJECT_FORM = "subject";
  private static final String MESSAGE_FIELD = "message";
  private static final String SUBMIT_BUTTON = "submit-button";
  private static final String SUCCESS_CLASS = ".status.alert.alert-success";
  private static final String DEFAULT_MESSAGE = "I'm testing a webpage!";
  private static final String DEFAULT_SUBJECT = "testing a web site";

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + NAME_FORM + DATA_QA_SELECTOR_SUFFIX)
  private WebElement nameFormField;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + EMAIL_FORM + DATA_QA_SELECTOR_SUFFIX)
  private WebElement emailFormField;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + SUBJECT_FORM + DATA_QA_SELECTOR_SUFFIX)
  private WebElement subjectFormField;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + MESSAGE_FIELD + DATA_QA_SELECTOR_SUFFIX)
  private WebElement messageFormField;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + SUBMIT_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement submitButton;

  @FindBy(css = SUCCESS_CLASS)
  private WebElement successClass;

  private WebDriver driver;

  public ContactUsPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public void fillForm(AbstractUser user) {
    nameFormField.sendKeys(user.getUserFirstname());
    emailFormField.sendKeys(user.getEmail());
    subjectFormField.sendKeys(DEFAULT_SUBJECT);
    messageFormField.sendKeys(DEFAULT_MESSAGE);
  }

  public String sendForm() {
   submitButton.click();
   Alert alert = driver.switchTo().alert();
   alert.accept();
   return successClass.getText();
  }
}
