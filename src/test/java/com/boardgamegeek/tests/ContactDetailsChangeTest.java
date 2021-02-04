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
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  "
                + loginProperties.getPassword());
        userMenuFragment.goToAccountPage();
        accountManagerPage.goToContactDetailsPage();
        testHelper.setCountry(contactDetailsPage.countryName());
        contactDetailsPage.insertAllDataToContactDetailsForm(testHelper.getFirstName(),
                testHelper.getLastName(), testHelper.getAddress(), testHelper.getCity(),
                testHelper.getStateOrProvince(), testHelper.getZipCode(), testHelper.getCountry(),
                testHelper.getWebsiteOrHomepage(), testHelper.getPhoneNumber(), testHelper.getXBoxTag(),
                testHelper.getBattleNetAccount(), testHelper.getSteamAccount(),
                testHelper.getWiiFriendCode(), testHelper.getPsnId());
        contactDetailsPage.confirmNewContactData(loginProperties.getPassword());
        menuFragment.returnHomePage();
        userMenuFragment.goToAccountPage();
        accountManagerPage.goToContactDetailsPage();
        assertThat(contactDetailsPage.getFirstName()).isEqualTo(testHelper.getFirstName());
        assertThat(contactDetailsPage.getLastName()).isEqualTo(testHelper.getLastName());
        assertThat(contactDetailsPage.getAddress()).isEqualTo(testHelper.getAddress());
        assertThat(contactDetailsPage.getCity()).isEqualTo(testHelper.getCity());
        assertThat(contactDetailsPage.getStateOrProvince()).isEqualTo(testHelper.getStateOrProvince());
        assertThat(contactDetailsPage.getZipCode()).isEqualTo(testHelper.getZipCode());
        assertThat(contactDetailsPage.getCountryName()).isEqualTo(testHelper.getCountry());
        assertThat(contactDetailsPage.getWebsiteOrHomepage()).isEqualTo(testHelper.getWebsiteOrHomepage());
        assertThat(contactDetailsPage.getPhoneNumber()).isEqualTo(testHelper.getPhoneNumber());
        assertThat(contactDetailsPage.getXBoxTag()).isEqualTo(testHelper.getXBoxTag());
        assertThat(contactDetailsPage.getBattleNetAccount()).isEqualTo(testHelper.getBattleNetAccount());
        assertThat(contactDetailsPage.getSteamAccount()).isEqualTo(testHelper.getSteamAccount());
        assertThat(contactDetailsPage.getWiiFriendCode()).isEqualTo(testHelper.getWiiFriendCode());
        assertThat(contactDetailsPage.getPsnId()).isEqualTo(testHelper.getPsnId());
    }
}
