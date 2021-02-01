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
        gamePage.addGameToCollection()
                .returnHomePage()
                .goToCollection();
        collectionPage.goToGameFromList(gameName);
        assertThat(gamePage.getGameTitle()).isEqualTo(gameName);
        Log.logInfo("The saved String of added game '" + gameName + "' is equal to the : '"
                + gamePage.getGameTitle() + "' game name in collection");
        assertThat(gamePage.getInformationIsGameAdded()).isEqualTo("In Collection");
        Log.logInfo("Game is added to collection, the Adding Button is changed to : " + gamePage.getInformationIsGameAdded());
    }

}
