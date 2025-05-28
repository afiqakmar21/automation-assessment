package com.assessment.tests;
import com.assessment.base.BaseTest;
import com.assessment.pages.LoginPage;
import com.assessment.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    // Creates instance for each test, before each test
    public void pageSetup() {
        loginPage = new LoginPage(driver);
    }

    // Login with valid username and password test
    @Test
    public void loginWithValidCredentials() {
        loginPage.login(LoginPage.validUname, LoginPage.validPass);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isAt());
    }

    // Login with invalid username and valid password test
    @Test
    public void loginWithInvalidUsername() {
        loginPage.login(LoginPage.invalidUname, LoginPage.validPass);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.invalidCredErrLoginMsg));
    }

    // Login with valid username and invalid password test
    @Test
    public void loginWithInvalidPassword() {
        loginPage.login(LoginPage.validUname, LoginPage.invalidPass);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.invalidCredErrLoginMsg));
    }

    // Login with invalid username and password test
    @Test
    public void loginWithInvalidCredentials() {
        loginPage.login(LoginPage.invalidUname, LoginPage.invalidPass);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.invalidCredErrLoginMsg));
    }

    // Login with blank username and password test
    @Test
    public void loginWithBlanks() {
        loginPage.login(LoginPage.blankStr, LoginPage.blankStr);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.blankUnameErrLoginMsg));
    }

    // Login with blank username and valid password test
    @Test
    public void loginWithBlankUsernameAndValidPassword() {
        loginPage.login(LoginPage.blankStr, LoginPage.validPass);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.blankUnameErrLoginMsg));
    }

    // Login with blank username and invalid password test
    @Test
    public void loginWithBlankUsernameAndInvalidPassword() {
        loginPage.login(LoginPage.blankStr, LoginPage.invalidPass);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.blankUnameErrLoginMsg));
    }

    // Login with valid username and blank password test

    @Test
    public void loginWithValidUsernameAndBlankPassword() {
        loginPage.login(LoginPage.validUname, LoginPage.blankStr);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.blankPassErrLoginMsg));
    }

    // Login with invalid username and blank password test
    @Test
    public void loginWithInvalidUsernameAndBlankPassword() {
        loginPage.login(LoginPage.invalidUname, LoginPage.blankStr);
        Assert.assertTrue(loginPage.getErrorMessage().contains(LoginPage.blankPassErrLoginMsg));
    }
}
