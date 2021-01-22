package com.boardgamegeek.tests;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends AbstractTest {


    @Test
    public void LogInTest () {

        homePage.clickSignInButton();
        homePage.signIn(testHelper.logInData, testHelper.logInData);

        assertThat(testHelper.logInData).isEqualTo(loggedHomePage.getLoggedUserLogin());

        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());

    }

}
