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
        loggedHomePage.goToDetailsChange()
                .insertDataToForm(testHelper.getFirstname(), testHelper.getLastname(), testHelper.getAddress(),
                        testHelper.getCity(), testHelper.getNewState(), testHelper.getZipCode(), testHelper.getWebsiteAddress(),
                        testHelper.getPhoneNumber(), testHelper.getXboxTag(), testHelper.getBattlenetAccount(),
                        testHelper.getSteamAccount(), testHelper.getWiiFriendCode(), testHelper.getPsnId(),
                        loginProperties.getPassword())
                .returnHomePage()
                .goToDetailsChange();
        assertThat(loggedHomePage.getFirstname()).isEqualTo(testHelper.getFirstname());
        assertThat(loggedHomePage.getLastname()).isEqualTo(testHelper.getLastname());
        assertThat(loggedHomePage.getAddress()).isEqualTo(testHelper.getAddress());
        assertThat(loggedHomePage.getCity()).isEqualTo(testHelper.getCity());
        assertThat(loggedHomePage.getNewState()).isEqualTo(testHelper.getNewState());
        assertThat(loggedHomePage.getZipcode()).isEqualTo(testHelper.getZipCode());
        assertThat(loggedHomePage.getWebsiteAddress()).isEqualTo(testHelper.getWebsiteAddress());
        assertThat(loggedHomePage.getPhoneNumber()).isEqualTo(testHelper.getPhoneNumber());
        assertThat(loggedHomePage.getXboxTag()).isEqualTo(testHelper.getXboxTag());
        assertThat(loggedHomePage.getBattlenetAccount()).isEqualTo(testHelper.getBattlenetAccount());
        assertThat(loggedHomePage.getSteamAccount()).isEqualTo(testHelper.getSteamAccount());
        assertThat(loggedHomePage.getWiiFriendCode()).isEqualTo(testHelper.getWiiFriendCode());
        assertThat(loggedHomePage.getPsnId()).isEqualTo(testHelper.getPsnId());
        Log.logInfo("All entered data is correct.");
    }

}
