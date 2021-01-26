package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() throws IOException {
        Log.logInfo("abc");
        homePage.clickSignInButton()
                    .signIn(loginProperties.loadUsername(), loginProperties.loadPassword())
                    .logInComparisonAssertion(loginProperties.loadUsername(), loggedHomePage.getLoggedUserLogin());
        Logger logger = Logger.getLogger(LogInTest.class);
        logger.getLogger("Logged user: " + loggedHomePage.getLoggedUserLogin());
        loggedHomePage.logout();
    }

}
