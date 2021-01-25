package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.TestHelper;
import org.testng.annotations.Test;

public class LogInTest extends AbstractTest {


    @Test(dataProvider = "positiveTestData", dataProviderClass = TestHelper.class)
    public void LogInTest(String username, String password) {
        System.out.println(username + ", " + password);
        homePage.clickSignInButton();
        homePage.signIn(username, password);
        homePage.logInComparisonAssertion(username, loggedHomePage.getLoggedUserLogin());
        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());
        loggedHomePage.logout();
    }

}
