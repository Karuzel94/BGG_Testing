package com.boardgamegeek.tests;

import com.boardgamegeek.pages.accountPage.AccountPage;
import com.boardgamegeek.pages.allBoardgamesPage.AllBoardgamesPage;
import com.boardgamegeek.pages.collectionPage.CollectionPage;
import com.boardgamegeek.pages.contactDetailsPage.ContactDetailsPage;
import com.boardgamegeek.pages.gamePage.GamePage;
import com.boardgamegeek.pages.homePage.HomePage;
import com.boardgamegeek.pages.joinPage.JoinPage;
import com.boardgamegeek.pages.loggedHomePage.LoggedHomePage;
import com.boardgamegeek.utilities.LoginProperties;
import com.boardgamegeek.utilities.TestHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    public String url = "https://boardgamegeek.com/";
    protected WebDriver driver;
    public HomePage homePage;
    public LoggedHomePage loggedHomePage;
    public JoinPage joinPage;
    public TestHelper testHelper;
    public LoginProperties loginProperties;
    public AccountPage accountPage;
    public ContactDetailsPage contactDetailsPage;
    public AllBoardgamesPage allBoardgamesPage;
    public CollectionPage collectionPage;
    public GamePage gamePage;

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
        loginProperties = new LoginProperties();
        accountPage = new AccountPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        allBoardgamesPage = new AllBoardgamesPage(driver);
        collectionPage = new CollectionPage(driver);
        gamePage = new GamePage(driver);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
