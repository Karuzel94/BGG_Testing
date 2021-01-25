package com.boardgamegeek.tests;

import com.boardgamegeek.pages.HomePage;
import com.boardgamegeek.pages.JoinPage;
import com.boardgamegeek.pages.LoggedHomePage;
import com.boardgamegeek.utilities.TestHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    public String url = "https://boardgamegeek.com/";
    protected WebDriver driver;
    public HomePage homePage;
    public LoggedHomePage loggedHomePage;
    public JoinPage joinPage;
    public TestHelper testHelper;

    @BeforeTest
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        homePage = new HomePage(driver);
        loggedHomePage = new LoggedHomePage(driver);
        joinPage = new JoinPage(driver);
        testHelper = new TestHelper();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
