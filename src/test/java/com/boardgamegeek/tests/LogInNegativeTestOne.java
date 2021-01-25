package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.TestHelper;
import org.testng.annotations.Test;

public class LogInNegativeTestOne extends AbstractTest {


    @Test(dataProvider = "getLogInData", dataProviderClass = TestHelper.class)
    public void LogInTest(String username, String password) {
        System.out.println(username + ", " + password);
        homePage.clickSignInButton();
        homePage.signIn(username, password);
        homePage.logInComparisonAssertion(username, loggedHomePage.getLoggedUserLogin());
        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());
        loggedHomePage.logout();
    }


}
