package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class GamesCollectionSortTest extends BaseTest {

    @Test
    public void gamesCollectionSortTestOne() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.sortCollectionByTitles();
        collectionPage.sortCollectionByTitles();
        testHelper.setListOfTitles(collectionPage.getGamesTitles());
        Log.logInfo(testHelper.getListOfTitles().toString());
        Log.logInfo(collectionPage.getGamesTitles().toString());
        assertThat(collectionPage.getGamesTitles()).isEqualTo(testHelper.getListOfTitles());
    }

    @Test
    public void gamesCollectionSortTestTwo() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.sortCollectionByRatings();
        assertThat(collectionPage.getGeekRatings()).isSortedAccordingTo(Comparator.reverseOrder());
        collectionPage.sortCollectionByRatings();
        assertThat(collectionPage.getGeekRatings()).isSorted();
    }

}
