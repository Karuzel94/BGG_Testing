package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyRatingChangingTest extends BaseTest{

    @Test
    public void myRatingChangingTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.getFirstGameFromList();
        testHelper.setTempNumber(testHelper.getRandomNumber(1,10));
        Log.logInfo(String.valueOf(testHelper.getTempNumber()));
        gamePage.giveMyRating(testHelper.getTempNumber());
        menuFragment.returnHomePage();
        userMenuFragment.goToCollection();
        assertThat(collectionPage.getRatingFromCollection()).isEqualTo(testHelper.getTempNumber());
        collectionPage.getFirstGameFromList();
        assertThat(gamePage.getSettedRating()).isEqualTo(testHelper.getTempNumber());
        assertThat(gamePage.countStarsNumber()).isEqualTo(testHelper.getTempNumber());

    }


}
