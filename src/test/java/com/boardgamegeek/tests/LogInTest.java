package com.boardgamegeek.tests;

import org.testng.annotations.Test;

public class LogInTest extends BaseTest {


    @Test
    public void LogInTest () {

        home.clickSignIn();
        home.signIn(logInData,logInData);
        home.confirmSignIn();
        System.out.println("Logged user: " + logged.loggedUser());

    }

}
