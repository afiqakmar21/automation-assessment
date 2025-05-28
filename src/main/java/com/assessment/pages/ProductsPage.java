package com.assessment.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    // The driver that will be used by this page
    WebDriver driver;

    // Constructor that accepts and initializes the WebDriver instance for this page
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Variables
    // Buttons
    private final By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    // Icons
    private final By shoppingCartIcon = By.className("shopping_cart_link");

    // Methods
    // Verifying Product page
    public boolean isAt() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
    // Adding backpack to cart
    public void addBackpackToCart(String productName) {
        driver.findElement(addBackpackToCartButton).click();
    }
    // Navigate to the cart page
    public void goToCart() {
        driver.findElement(shoppingCartIcon).click();
    }
}
