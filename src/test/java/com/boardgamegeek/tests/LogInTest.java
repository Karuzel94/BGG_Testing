package com.boardgamegeek.tests;

import org.testng.annotations.Test;

import org.apache.log4j.Logger;

public class LogInTest extends BaseTest {


    @Test
    public void logInTest() {
        System.out.println(testHelper.logInUsername + ", " + testHelper.logInPassword);
        homePage.clickSignInButton()
                    .signIn(testHelper.logInUsername, testHelper.logInPassword)
                    .logInComparisonAssertion(testHelper.logInUsername, loggedHomePage.getLoggedUserLogin());
        Logger logger = Logger.getLogger(LogInTest.class);
        logger.getLogger("Logged user: " + loggedHomePage.getLoggedUserLogin());
        loggedHomePage.logout();
    }

}
