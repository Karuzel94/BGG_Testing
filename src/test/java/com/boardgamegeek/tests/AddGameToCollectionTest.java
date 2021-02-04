package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddGameToCollectionTest extends BaseTest {

    @Test
    public void addGameToCollectionTest() {

        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        menuFragment.goToAllBoardgames();
        allBoardgamesPage.goToRandomGame();
        testHelper.setGameName(gamePage.getGameTitle());
        gamePage.addGameToCollection();
        menuFragment.returnHomePage();
        userMenuFragment.goToCollection();
        collectionPage.goToGameFromList(testHelper.getGameName());
        assertThat(gamePage.getGameTitle()).isEqualTo(testHelper.getGameName());
        assertThat(gamePage.getInformationIsGameAdded()).isEqualTo("In Collection");
    }

}
