package com.boardgamegeek.tests;

import com.boardgamegeek.pages.homePage.HomePage;
import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactDetailsChangeTest extends BaseTest {

    @Test
    public void contactDetailsChangeTest() {

        homePage.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(loggedUserMenuFragment.getLoggedUserLogin()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        loggedHomePage.goToAccountPage();
        accountPage.goToDetailsChange();
        contactDetailsPage.insertDataToContactDetailsFormAndConfirm(testHelper.getFirstname(), testHelper.getLastname(), testHelper.getAddress(),
                testHelper.getCity(), testHelper.getNewState(), testHelper.getZipCode(), testHelper.getWebsiteAddress(),
                testHelper.getPhoneNumber(), testHelper.getXboxTag(), testHelper.getBattlenetAccount(),
                testHelper.getSteamAccount(), testHelper.getWiiFriendCode(), testHelper.getPsnId(),
                loginProperties.getPassword());
        homePage.returnHomePage();
        loggedUserMenuFragment.goToAccountPage();
        accountPage.goToDetailsChange();
        assertThat(contactDetailsPage.getFirstName()).isEqualTo(testHelper.getFirstname());
        assertThat(contactDetailsPage.getLastName()).isEqualTo(testHelper.getLastname());
        assertThat(contactDetailsPage.getAddress()).isEqualTo(testHelper.getAddress());
        assertThat(contactDetailsPage.getCity()).isEqualTo(testHelper.getCity());
        assertThat(contactDetailsPage.getNewState()).isEqualTo(testHelper.getNewState());
        assertThat(contactDetailsPage.getZipCode()).isEqualTo(testHelper.getZipCode());
        assertThat(contactDetailsPage.getWebsiteAddress()).isEqualTo(testHelper.getWebsiteAddress());
        assertThat(contactDetailsPage.getPhoneNumber()).isEqualTo(testHelper.getPhoneNumber());
        assertThat(contactDetailsPage.getXboxTag()).isEqualTo(testHelper.getXboxTag());
        assertThat(contactDetailsPage.getBattlenetAccount()).isEqualTo(testHelper.getBattlenetAccount());
        assertThat(contactDetailsPage.getSteamAccount()).isEqualTo(testHelper.getSteamAccount());
        assertThat(contactDetailsPage.getWiiFriendCode()).isEqualTo(testHelper.getWiiFriendCode());
        assertThat(contactDetailsPage.getPsnId()).isEqualTo(testHelper.getPsnId());
        Log.logInfo("All entered data is correct.");
    }

}
