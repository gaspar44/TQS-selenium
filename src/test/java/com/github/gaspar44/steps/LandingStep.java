package com.github.gaspar44.steps;

import com.github.gaspar44.ui.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class LandingStep {
	WebDriver driver;

	public LandingStep() throws Exception {
		driver = WebDriverFactory.getDriver(WebDriverFactory.DriverID.CHROME);
	}

	@Given("I'm in the lading page")
	public void start() {
		driver.get("https://google.com");
	}

	@After
	public void shutDown() {
		if (driver != null) {
			driver.close();
		}
	}
}
