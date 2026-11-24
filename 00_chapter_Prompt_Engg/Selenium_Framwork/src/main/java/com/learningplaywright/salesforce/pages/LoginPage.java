package com.learningplaywright.salesforce.pages;

import com.learningplaywright.salesforce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMe;

    private final By usernameLocator = By.xpath("//input[@id='username']");
    private final By passwordLocator = By.xpath("//input[@id='password']");
    private final By loginErrorLocator = By.xpath("//div[@id='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        try {
            driver.get(url);
            visible(usernameLocator);
        } catch (RuntimeException exception) {
            throw new IllegalStateException("Unable to open Salesforce login page", exception);
        }
    }

    public void enterUsername(String value) {
        visible(usernameLocator).clear();
        username.sendKeys(value);
    }

    public void enterPassword(String value) {
        visible(passwordLocator).clear();
        password.sendKeys(value);
    }

    public void selectRememberMe() {
        WebElement checkbox = visible(By.xpath("//input[@id='rememberUn']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void login(String usernameValue, String passwordValue) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickable(By.xpath("//input[@id='Login']")).click();
    }

    public String getLoginError() {
        return visible(loginErrorLocator).getText();
    }

    public boolean isLoginErrorDisplayed() {
        return wait.until(driver -> {
            try {
                return driver.findElement(loginErrorLocator).isDisplayed();
            } catch (org.openqa.selenium.NoSuchElementException exception) {
                return false;
            }
        });
    }

    public boolean isLoginSuccessful() {
        return urlContains("lightning") || urlContains("home");
    }
}
