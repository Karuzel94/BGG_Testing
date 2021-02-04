package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationTest() {
        joinPage.clickJoinInButton();
        joinPage.accountRegistration(testHelper.getUserName(), testHelper.getUserMail(), testHelper.getPassword());
        Log.logInfo("Registered user is: " + userMenuFragment.getUserName()
                + "\nNEW ACCOUNT DATA BELOW!!!\n Username: " + testHelper.getUserName()
                + "   Mail: " + testHelper.getUserMail() + "   Password: " + testHelper.getPassword());
        assertThat(testHelper.getUserName()).isEqualTo(userMenuFragment.getUserName());
    }

}
