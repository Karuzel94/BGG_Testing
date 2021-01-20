package com.bgg.tests;

import com.bgg.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogInTest extends AbstractTest {


    @Test
    public void LogInTest () {

        String logInData = "bggtest1221";
        HomePage home = new HomePage(driver);

        home.clickSignIn();
        home.enterUserName(logInData);
        home.enterPassword(logInData);
        home.confirmSignIn();


    }

}
