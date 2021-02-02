package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactDetailsChangeTest extends BaseTest {

    @Test
    public void contactDetailsChangeTest() {

        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        userMenuFragment.goToAccountPage();
        accountManagerPage.goToContactDetailsPage();
        contactDetailsPage.insertDataToContactDetailsForm(testHelper.getFirstname(), testHelper.getLastname(), testHelper.getAddress(),
                testHelper.getCity(), testHelper.getNewState(), testHelper.getZipCode(), testHelper.getCountryIndex(), testHelper.getWebsiteAddress(),
                testHelper.getPhoneNumber(), testHelper.getXboxTag(), testHelper.getBattlenetAccount(),
                testHelper.getSteamAccount(), testHelper.getWiiFriendCode(), testHelper.getPsnId());
        String countryName = contactDetailsPage.getCountryName();
        contactDetailsPage.confirmNewContactData(loginProperties.getPassword());
        menuFragment.returnHomePage();
        userMenuFragment.goToAccountPage();
        accountManagerPage.goToContactDetailsPage();
        assertThat(contactDetailsPage.getFirstName()).isEqualTo(testHelper.getFirstname());
        assertThat(contactDetailsPage.getLastName()).isEqualTo(testHelper.getLastname());
        assertThat(contactDetailsPage.getAddress()).isEqualTo(testHelper.getAddress());
        assertThat(contactDetailsPage.getCity()).isEqualTo(testHelper.getCity());
        assertThat(contactDetailsPage.getNewState()).isEqualTo(testHelper.getNewState());
        assertThat(contactDetailsPage.getZipCode()).isEqualTo(testHelper.getZipCode());
        assertThat(contactDetailsPage.getCountryName()).isEqualTo(countryName);
        assertThat(contactDetailsPage.getWebsiteAddress()).isEqualTo(testHelper.getWebsiteAddress());
        assertThat(contactDetailsPage.getPhoneNumber()).isEqualTo(testHelper.getPhoneNumber());
        assertThat(contactDetailsPage.getXboxTag()).isEqualTo(testHelper.getXboxTag());
        assertThat(contactDetailsPage.getBattleNetAccount()).isEqualTo(testHelper.getBattlenetAccount());
        assertThat(contactDetailsPage.getSteamAccount()).isEqualTo(testHelper.getSteamAccount());
        assertThat(contactDetailsPage.getWiiFriendCode()).isEqualTo(testHelper.getWiiFriendCode());
        assertThat(contactDetailsPage.getPsnId()).isEqualTo(testHelper.getPsnId());
    }

}
