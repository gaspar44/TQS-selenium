package io.cucumber.pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.sample.AbstractUser;
import io.cucumber.sample.DemoUser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBasic {

    // Body
    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProduct1Button;

    @FindBy(id = "accordian")
    private WebElement categories;

    @FindBy(xpath = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;

    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dressCategory;

    @FindBy(css = "div[class='recommended_items'] h2")
    private WebElement recommendedItems;

    @FindBy(css = "div[id='recommended-item-carousel'] a[class='btn btn-default add-to-cart']")
    private WebElement blueTopAddToCartButton;

    @FindBy(css = "div[class='modal-content'] a[href='/view_cart']")
    private WebElement viewCartButton;

    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

    @FindBy(xpath = "//section[1]/div/div/div/div/div/div[1]/div[1]/h2")
    private WebElement fullFledgedPracticeWebsiteForAutomationEngineers;

    //footer
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscription;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "success-subscribe")
    private WebElement alertSuccessSubscribe;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }

    public LoginSignupPage signupLoginClick() {
        signupLoginButton.click();
        return new LoginSignupPage(driver);
    }

    public ContactUsPage contactUsButtonClick() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage testCasesButtonClick() {
        testCasesButton.click();
        return new TestCasesPage(driver);
    }

    public ProductsPage productsButtonClick() {
        productsButton.click();
        return new ProductsPage(driver);
    }

    public CartPage cartButtonClick() {
        cartButton.click();
        return new CartPage(driver);
    }

    public ProductDetailPage viewProduct1ButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(driver1 -> driver.findElements(viewProduct1Button).size() > 0);
        viewProduct1Button.click();
        return new ProductDetailPage(driver);
    }

    public WebElement getCategories() {
        return categories;
    }

    public HomePage womenCategoryClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(driver1 -> driver.findElements(womenCategory).size() > 0);
        womenCategory.click();
        return this;
    }

    public ProductsPage dressCategoryClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(dressCategory)));
        dressCategory.click();
        return new ProductsPage(driver);
    }

    public WebElement getRecommendedItems() {
        return recommendedItems;
    }

    public HomePage blueTopAddToCartButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(blueTopAddToCartButton)));        blueTopAddToCartButton.click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        viewCartButton.click();
        return new CartPage(driver);
    }

    public HomePage scrollUpButtonClick() {
        scrollUpButton.click();
        return this;
    }

    public WebElement getFullFledgedPracticeWebsiteForAutomationEngineers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(fullFledgedPracticeWebsiteForAutomationEngineers));
        return fullFledgedPracticeWebsiteForAutomationEngineers;
    }


    //footer
    public WebElement getSubscription() {
        return subscription;
    }

    public HomePage fillSubscribe(AbstractUser user) throws IOException {
        subscribeEmailInput.sendKeys(user.getEmail());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(subscribeButton)));
        subscribeButton.click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return alertSuccessSubscribe;
    }
}