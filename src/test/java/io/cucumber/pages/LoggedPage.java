package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedPage {
  public static final String EXPECTED_DELETE_TEXT = "ACCOUNT DELETED!";
  private static final String DATA_QA_SELECTOR_PREFIX = "[data-qa='";
  private static final String DATA_QA_SELECTOR_SUFFIX = "']";
  private static final String DELETED_ACCOUNT = "account-deleted";
  private static final String CONTINUE_BUTTON = "continue-button";

  @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
  private WebElement username;

  @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[5]/a")
  private WebElement deleteAccountButton;

  @FindBy(xpath = "//header/div/div/div/div[2]/div/ul/li[4]/a")
  private WebElement logoutButton;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + DELETED_ACCOUNT + DATA_QA_SELECTOR_SUFFIX)
  private WebElement deletedAccountText;

  @FindBy(css = DATA_QA_SELECTOR_PREFIX + CONTINUE_BUTTON + DATA_QA_SELECTOR_SUFFIX)
  private WebElement continueButton;

  public LoggedPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
  public String getUsername() {
    return username.getText();
  }

  public String deleteUser() throws Exception {
    deleteAccountButton.click();
    String deletedText = deletedAccountText.getText();
    continueButton.click();
    return deletedText;
  }

  public void logout() throws Exception {
    logoutButton.click();
  }
}
