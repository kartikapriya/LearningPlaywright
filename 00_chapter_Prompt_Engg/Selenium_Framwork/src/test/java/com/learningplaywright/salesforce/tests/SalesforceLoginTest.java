package com.learningplaywright.salesforce.tests;

import com.learningplaywright.salesforce.base.DriverFactory;
import com.learningplaywright.salesforce.config.ConfigReader;
import com.learningplaywright.salesforce.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class SalesforceLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String loginUrl;

    @BeforeTest
    public void readConfiguration() {
        loginUrl = ConfigReader.get("SALESFORCE_LOGIN_URL");
        if (loginUrl.isBlank()) {
            loginUrl = "https://login.salesforce.com/?locale=in";
        }
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.create(ConfigReader.get("BROWSER"));
        loginPage = new LoginPage(driver);
        loginPage.open(loginUrl);
    }

    @Test(priority = 1)
    public void validLoginTest() {
        String username = ConfigReader.getRequired("SALESFORCE_USERNAME");
        String password = ConfigReader.getRequired("SALESFORCE_PASSWORD");

        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "A valid Salesforce login did not navigate to the authenticated application.");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        loginPage.login(
                "invalid.user@example.com",
                "InvalidPassword123!"
        );

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "An invalid login did not display a Salesforce authentication error.");
        Assert.assertFalse(loginPage.getLoginError().isBlank(),
                "The Salesforce authentication error message must not be blank.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE && driver instanceof TakesScreenshot screenshot) {
                Path output = Path.of("target", "screenshots",
                        result.getMethod().getMethodName() + ".png");
                Files.createDirectories(output.getParent());
                Files.write(output, screenshot.getScreenshotAs(OutputType.BYTES));
            }
        } catch (Exception exception) {
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(exception);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
