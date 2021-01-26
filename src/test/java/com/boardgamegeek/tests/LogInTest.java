package com.boardgamegeek.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogInTest extends AbstractTest {


    @Test
    @Parameters({"username","password"})
    public void LogInTest( @Optional ("Abc") String username, String password) {
        System.out.println(username + ", " + password);
        homePage.clickSignInButton();
        homePage.signIn(username, password);
        homePage.logInComparisonAssertion(username, loggedHomePage.getLoggedUserLogin());
        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());
        loggedHomePage.logout();
    }

}
