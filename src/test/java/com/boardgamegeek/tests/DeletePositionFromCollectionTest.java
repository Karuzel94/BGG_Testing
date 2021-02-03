package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeletePositionFromCollectionTest extends BaseTest {

    @Test
    public void deletePositionFromCollectionTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.chooseRandomGameFromList();
        String gameName = gamePage.getGameTitle();
        gamePage.deleteGameFromCollection();
        menuFragment.returnHomePage();
        userMenuFragment.goToCollection();
        collectionPage.checkIfTheGameHasBeenDeleted(gameName);
    }
}
