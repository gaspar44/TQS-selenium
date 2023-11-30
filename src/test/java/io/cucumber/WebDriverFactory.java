package io.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Collections;

public class WebDriverFactory {
  public enum DriverID {
    FIREFOX, CHROME
  }

  public static WebDriver getDriver(DriverID driverID) throws Exception {
    return getDriver(driverID, new URL("http://localhost:4444"));
  }

  public static WebDriver getDriver(DriverID driverID, URL serverUri) throws Exception {
    HttpCommandExecutor executor = new HttpCommandExecutor(Collections.emptyMap(), serverUri);
    switch (driverID) {
      case CHROME:
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        return new RemoteWebDriver(executor, chromeOptions);
      case FIREFOX:
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        return new RemoteWebDriver(executor, firefoxOptions);
      default:
        throw new Exception();
    }
  }
}
