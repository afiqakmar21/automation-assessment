package com.assessment.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    // The driver that will be used by this page
    WebDriver driver;

    // Constructor that accepts and initializes the WebDriver instance for this page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Variables
    // Credentials
    public static final String validUname = "standard_user";
    public static final String invalidUname = "invalid_username";
    public static final String validPass = "secret_sauce";
    public static final String invalidPass = "invalid_password";
    public static final String blankStr = "";
    // Login error messages
    public static final String invalidCredErrLoginMsg = "Epic sadface: Username and password do not match any user in this service";
    public static final String blankUnameErrLoginMsg = "Epic sadface: Username is required";
    public static final String blankPassErrLoginMsg = "Epic sadface: Password is required";
    // Text Fields
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    // Buttons
    private final By loginButton = By.id("login-button");
    // Toast
    private final By errorMessage = By.cssSelector("h3[data-test='error'");

    // Methods
    // Verifying Login page
    public boolean isAt() {
        return driver.getCurrentUrl().contains("https://www.saucedemo.com/");
    }

    // Perform login actions
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    // Acquire error message string
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
