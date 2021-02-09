package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteGameFromCollectionTest extends BaseTest {

    @Test
    public void deleteGameFromCollectionTest() {

        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.chooseRandomGameFromList();
        testHelper.setGameName(gamePage.getGameTitle());
        gamePage.deleteGameFromCollection();
        menuFragment.returnHomePage();
        userMenuFragment.goToCollection();
        assertThat(collectionPage.getGamesTitles()).doesNotContain(testHelper.getGameName());
    }
}
