package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GamesCollectionSortTest extends BaseTest {

    @Test
    public void gamesCollectionSortTestOne() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        testHelper.setTempListOfTitles(collectionPage.getTempListOfTitles());
        collectionPage.sortCollectionByTitles();
        Log.logInfo("temp     " + testHelper.getTempListOfTitles());
        Log.logInfo("original " + collectionPage.getSortedListWithGameTitles());
        assertThat(testHelper.getTempListOfTitles()).isEqualTo(collectionPage.getSortedListWithGameTitles());
        testHelper.setTempListOfTitles(collectionPage.getTempListOfTitles());
        collectionPage.sortCollectionByTitles();
        Log.logInfo("temp     " + testHelper.getTempListOfTitles());
        Log.logInfo("original " + collectionPage.getSortedListWithGameTitles());
        assertThat(testHelper.getTempListOfTitles()).isEqualTo(collectionPage.getSortedListWithGameTitles());
    }

    @Test
    public void gamesCollectionSortTestTwo() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        testHelper.setTempListOfRatings(collectionPage.getTempListOfRatings());
        collectionPage.sortCollectionByRatings();
        Log.logInfo("temp     " + testHelper.getTempListOfRatings());
        Log.logInfo("original " + collectionPage.getSortedListWithGameRatings());
        assertThat(testHelper.getTempListOfRatings()).isEqualTo(collectionPage.getSortedListWithGameRatings());
        testHelper.setTempListOfRatings(collectionPage.getTempListOfRatings());
        collectionPage.sortCollectionByRatings();
        Log.logInfo("temp     " + testHelper.getTempListOfRatings());
        Log.logInfo("original " + collectionPage.getSortedListWithGameRatings());
        assertThat(testHelper.getTempListOfRatings()).isEqualTo(collectionPage.getSortedListWithGameRatings());
    }

}
