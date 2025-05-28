package com.assessment.tests;
import com.assessment.base.BaseTest;
import com.assessment.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void pageSetup() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    // Variables
    public static final String sauceLabsBackpackStr = "Sauce Labs Backpack";
    public static final String firstName = "John";
    public static final String lastName = "Doe";
    public static final String postalCode = "12345";

    @Test
    public void checkoutCompleteTest() {
        // Step 1: Login and ensure user lands on the Products page
        loginPage.login(LoginPage.validUname, LoginPage.validPass);
        Assert.assertTrue(productsPage.isAt());

        // Step 2: Add product to cart and go to cart
        productsPage.addBackpackToCart(sauceLabsBackpackStr);
        productsPage.goToCart();

        // Step 3: Verify item in cart then proceed to checkout
        cartPage.verifyItemInCart();
        cartPage.clickCheckoutButton();

        // Step 4: Enter checkout info
        checkoutInfoPage.enterCheckoutInfo(firstName, lastName, postalCode);

        // Step 5: Finish checkout
        checkoutOverviewPage.verifyCheckoutAndFinish();

        // Step 6: Verify checkout completion
        Assert.assertTrue(checkoutCompletePage.isAt());
        Assert.assertTrue(checkoutCompletePage.isCheckoutComplete());
    }
}
