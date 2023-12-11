package io.cucumber;

import io.cucumber.pages.LoggedPage;
import io.cucumber.pages.RegisterHomePage;
import io.cucumber.pages.RegisterOrLoginLandingPage;
import io.cucumber.sample.AbstractUser;
import org.openqa.selenium.WebDriver;

public class UIHelper {

  public static void registerUser(WebDriver driver, AbstractUser user) throws Exception {
    RegisterOrLoginLandingPage homePage = new RegisterOrLoginLandingPage(driver);
    homePage.register(user);
    RegisterHomePage registerHomePage = new RegisterHomePage(driver);
    registerHomePage.fillPage(user);
  }

  public static void removeUser(WebDriver driver) throws Exception {
    LoggedPage loggedPage = new LoggedPage(driver);
    loggedPage.deleteUser();
  }
}
