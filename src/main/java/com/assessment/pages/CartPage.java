package com.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    // The driver that will be used by this page
    WebDriver driver;

    // Constructor that accepts and initializes the WebDriver instance for this page
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Variables
    // Buttons
    private final By checkoutButton = By.id("checkout");
    // Links
    private final By backpackNameInCartLink = By.xpath("//a[@id='item_4_title_link']/div[text()='Sauce Labs Backpack']");

    public void verifyItemInCart() {
        driver.findElement(backpackNameInCartLink).isDisplayed();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}