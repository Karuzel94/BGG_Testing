package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        assertThat(homePage.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword())
                .getUsername(loggedHomePage)).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        loggedHomePage.logout();
    }

    @Test
    @Parameters({"username", "password"})
    public void logInTest2(@Optional("ABC") String username, String password) {
        homePage.clickSignInButton()
                .signIn(username, password);
        assertThat(loggedHomePage.getLoggedUserLogin()).isEqualTo(username);
        Log.logInfo("Username: " + username + ", Password:  " + password);
        loggedHomePage.logout();
    }

    @Test
    public void logInTest3() {
        homePage.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(loggedHomePage.getLoggedUserLogin()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        loggedHomePage.logout();
    }
}
