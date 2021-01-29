package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationTest() {
        homePage.clickJoinInButton();
        joinPage.registerAccount(testHelper.getUserName(), testHelper.getUserMail(), testHelper.getPassword());
        Log.logInfo("Registered user is: " + loggedUserMenuFragment.getLoggedUserLogin());
        Log.logInfo("NEW ACCOUNT DATA BELOW!!!");
        Log.logInfo("Username: " + testHelper.getUserName());
        Log.logInfo("Mail: " + testHelper.getUserMail());
        Log.logInfo("Password: " + testHelper.getPassword());
        assertThat(testHelper.getUserName()).isEqualTo(loggedUserMenuFragment.getLoggedUserLogin());
    }

}
