package com.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
    // The driver that will be used by this page
    WebDriver driver;

    // Constructor that accepts and initializes the WebDriver instance for this page
    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Variables
    // Text Fields
    private final By firstNameTextfield = By.id("first-name");
    private final By lastNameTextfield = By.id("last-name");
    private final By postalCodeTextfield = By.id("postal-code");
    // Buttons
    private final By continueToCheckoutOverviewButton = By.id("continue");

    // Methods
    // Enter checkout info
    public void enterCheckoutInfo(String firstName, String lastName, String zip) {
        driver.findElement(firstNameTextfield).sendKeys(firstName);
        driver.findElement(lastNameTextfield).sendKeys(lastName);
        driver.findElement(postalCodeTextfield).sendKeys(zip);
        driver.findElement(continueToCheckoutOverviewButton).click();
    }
}
