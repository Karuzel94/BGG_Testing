package com.boardgamegeek.tests;

import com.boardgamegeek.pages.HomePage;
import com.boardgamegeek.pages.JoinPage;
import com.boardgamegeek.pages.LoggedHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public String url = "https://boardgamegeek.com/";
    WebDriver driver;
    HomePage home;
    LoggedHomePage logged;
    JoinPage join;

    public String randomString(int length, boolean isLetters, boolean isNumbers) {
        return RandomStringUtils.random(length, isLetters, isNumbers);
    }

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
        home = new HomePage(driver);
        logged = new LoggedHomePage(driver);
        join = new JoinPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
