package com.boardgamegeek.tests;

import com.boardgamegeek.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {


    @Test
    public void LogInTest () {

        String logInData = "bggtest1221";

        home.clickSignIn();
        home.signIn(logInData,logInData);
        home.confirmSignIn();
        System.out.println("Logged user: " + logged.loggedUser());

    }

}
