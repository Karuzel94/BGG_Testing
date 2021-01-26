package com.boardgamegeek.tests;

import org.testng.annotations.Test;

public class LogInTest extends AbstractTest {


    @Test
    public void logInTest() {
        System.out.println(testHelper.logInUsername + ", " + testHelper.logInPassword);
        homePage.clickSignInButton()
                    .signIn(testHelper.logInUsername, testHelper.logInPassword)
                    .logInComparisonAssertion(testHelper.logInUsername, loggedHomePage.getLoggedUserLogin());
        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());
        loggedHomePage.logout();
    }

}
