package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationTest() {
        homePage.clickJoinInButton();
        joinPage.registerAccount(testHelper.userName, testHelper.userMail, testHelper.password);
        Log.logInfo("Registered user is: " + loggedHomePage.getLoggedUserLogin());
        Log.logInfo("NEW ACCOUNT DATA BELOW!!!");
        Log.logInfo("Username: " + testHelper.userName);
        Log.logInfo("Mail: " + testHelper.userMail);
        Log.logInfo("Password: " + testHelper.password);
        assertThat(testHelper.userName).isEqualTo(loggedHomePage.getLoggedUserLogin());
    }

}
