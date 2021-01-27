package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactDetailsChangeTest extends BaseTest {

    @Test
    public void contactDetailsChangeTest() {

        assertThat(homePage.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword())
                .getUsername(loggedHomePage)).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        loggedHomePage.goToDetailsChange();
        //dodać Stringi jako parametry, 14 sztuk xD
        loggedHomePage.insertDataToForm(testHelper.getFirstname(), testHelper.getLastname(), testHelper.getAddress(),
                testHelper.getCity(), testHelper.getNewState(), testHelper.getZipCode(), testHelper.getWebsite(),
                testHelper.getPhoneNumber(), testHelper.getXboxTag(), testHelper.getBattlenetAccount(),
                testHelper.getSteamAccount(), testHelper.getWiiFriendCode(), testHelper.getPsnId(),
                loginProperties.getPassword())
                .returnHomePage();
        loggedHomePage.goToDetailsChange();
        Log.logInfo(loggedHomePage.getCity());
        assertThat(loggedHomePage.getCity()).isEqualTo(testHelper.getCity());
    }

}
