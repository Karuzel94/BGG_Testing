package com.bgg.tests;

import com.bgg.pages.HomePage;
import com.bgg.pages.JoinPage;
import com.bgg.pages.LoggedHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    public String url = "https://boardgamegeek.com/";
    WebDriver driver;
    public HomePage home;
    public LoggedHomePage logged;
    public JoinPage join;

    @BeforeTest
    public static void  setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
