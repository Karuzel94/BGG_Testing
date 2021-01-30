package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddPositionToCollectionTest extends BaseTest {

    @Test
    public void addPositionToCollectionTest() {

        homePage.clickSignInButton();
        homePage.signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(loggedHomePage.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername() + ", Password:  " + loginProperties.getPassword());
        loggedHomePage.goToAllBoardgames();
        allBoardgamesPage.chooseGame(testHelper.getGameIndex());
        Log.logInfo(gamePage.getGameTitle());
        String gameName = gamePage.getGameTitle();
        gamePage.addGameToCollection().returnHomePage().goToCollection();
        collectionPage.goToGameFromList(gameName);
        Log.logInfo(gameName);
        assertThat(gamePage.getGameTitle()).isEqualTo(gameName);
        Log.logInfo("The saved String of added game '" + gameName + "' is equal to the game name: '"
                + gamePage.getGameTitle() +"' game name in collection");
    }

}
