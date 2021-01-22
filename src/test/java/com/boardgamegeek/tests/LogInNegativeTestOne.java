package com.boardgamegeek.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LogInNegativeTestOne extends AbstractTest {


    @Test
    public void LogInTest () {

        homePage.clickSignInButton();
        homePage.signIn(testHelper.logInData, testHelper.logInData);

        Assert.assertNotEquals(testHelper.logInData, loggedHomePage.getLoggedUserLogin());

        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());

    }

}
