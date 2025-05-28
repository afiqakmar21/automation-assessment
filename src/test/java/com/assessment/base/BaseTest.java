package com.assessment.base;
import com.assessment.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Automatically downloads and configures the correct version of ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Creates a new instance of the Chrome browser using Selenium
        driver = new ChromeDriver(options);
        // Maximizes the browser window to full screen
        driver.manage().window().maximize();
        // Navigate browser to a specific URL, value declared in Utilities page
        driver.get(Utilities.URL);

//        SafariOptions options = new SafariOptions();
//
//        // You can set Safari options here if needed
//
//        driver = new SafariDriver(options);
//
//        driver.manage().window().maximize();
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
