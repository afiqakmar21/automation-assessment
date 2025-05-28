package com.assessment.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    // The driver that will be used by this page
    WebDriver driver;

    // Constructor that accepts and initializes the WebDriver instance for this page
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Variables
    public static final String checkoutCompletePageURLStr = "checkout-complete.html";
    public static final String checkoutCompleteToastStr = "Thank you for your order!";

    // Verifying Checkout complete page
    public boolean isAt() {
        return driver.getCurrentUrl().contains(checkoutCompletePageURLStr);
    }
    // Verify checkout is completed
    public boolean isCheckoutComplete() {
        return driver.getPageSource().contains(checkoutCompleteToastStr);
    }
}
