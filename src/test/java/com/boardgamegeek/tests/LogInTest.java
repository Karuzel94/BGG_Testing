package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {

        assertThat(signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword())
                .getUsername(userMenuFragment)).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        userMenuFragment.logout();
    }

    @Test
    @Parameters({"username", "password"})
    public void logInTest2(@Optional("ABC") String username, String password) {
        signInFragment.clickSignInButton()
                .signIn(username, password);
        assertThat(userMenuFragment.getUserName()).isEqualTo(username);
        Log.logInfo("Username: " + username + ", Password:  " + password);
        userMenuFragment.logout();
    }

    @Test
    public void logInTest3() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        userMenuFragment.logout();
    }
}
