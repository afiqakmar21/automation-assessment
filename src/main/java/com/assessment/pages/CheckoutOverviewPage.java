package com.assessment.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    // The driver that will be used by this page
    WebDriver driver;

    // Constructor that accepts and initializes the WebDriver instance for this page
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Variables
    private final By verifyItemCheckoutOverview = By.xpath("//div[@class='cart_item_label' and a[@id='item_4_title_link']/div[text()='Sauce Labs Backpack'] and div[@class='item_pricebar']/div[@class='inventory_item_price' and text()='29.99']]");
    private final By finishCheckoutButton = By.id("finish");

    public void verifyCheckoutAndFinish() {
        driver.findElement(verifyItemCheckoutOverview).isDisplayed();
        driver.findElement(finishCheckoutButton).click();
    }
}
