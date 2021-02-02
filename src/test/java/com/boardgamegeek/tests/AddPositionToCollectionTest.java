package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddPositionToCollectionTest extends BaseTest {

    @Test
    public void addPositionToCollectionTest() {

        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        menuFragment.goToAllBoardgames();
        allBoardgamesPage.goToRandomGame(testHelper.getGameIndex());
        String gameName = gamePage.getGameTitle();
        Log.logInfo(gameName);
        gamePage.addGameToCollection();
        menuFragment.returnHomePage();
        userMenuFragment.goToCollection();
        collectionPage.goToGameFromList(gameName);
        assertThat(gamePage.getGameTitle()).isEqualTo(gameName);
        Log.logInfo("The saved String of added game '" + gameName + "' is equal to the : '"
                + gamePage.getGameTitle() + "' game name in collection");
        assertThat(gamePage.getInformationIsGameAdded()).isEqualTo("In Collection");
        Log.logInfo("Game is added to collection, the Adding Button is changed to : " + gamePage.getInformationIsGameAdded());
    }

}
