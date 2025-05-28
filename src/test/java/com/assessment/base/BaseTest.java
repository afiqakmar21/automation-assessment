package com.assessment.base;

import com.assessment.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // CHROME BROWSER
        // Automatically downloads and configures the correct version of ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Creates a new instance of the Chrome browser using Selenium
        driver = new ChromeDriver(options);
        // Maximizes the browser window to full screen
        driver.manage().window().maximize();
        // Navigate browser to a specific URL, value declared in Utilities page
        driver.get(Utilities.URL);

//        // SAFARI BROWSER
//        SafariOptions options = new SafariOptions();
//        //Creates a new instance of the Safari browser using Selenium
//        driver = new SafariDriver(options);
//        // Maximizes the browser window to full screen
//        driver.manage().window().maximize();
//        // Navigate browser to a specific URL, value declared in Utilities page
//        driver.get(Utilities.URL);

//        // FIREFOX BROWSER
//        // Automatically sets up GeckoDriver for Firefox
//        WebDriverManager.firefoxdriver().setup();
//        // Initialize Firefox browser
//        // Creates a new instance of the Chrome browser using Selenium
//        driver = new FirefoxDriver();
//        // Maximizes the browser window to full screen
//        driver.manage().window().maximize();
//        // Navigate browser to a specific URL, value declared in Utilities page
//        driver.get(Utilities.URL);

    }

    @AfterMethod
    public void tearDown() {
        // Checks if the driver has actually been initialized and is not null. A safety check to avoid NullPointerException in case driver wasn't set up for some reason
        if (driver != null) {
            // Close the browser
            driver.quit();
        }
    }
}
