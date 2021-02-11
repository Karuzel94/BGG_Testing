package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilteringCollectionTest extends BaseTest {

    @Test
    public void filteringCollectionByGeekRatingTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.geekRatingFiltering(7.0, 9.0)
                .acceptFilters();
        Log.logInfo("How many records after filtering? " + collectionPage.getGeekRatings().size());
        for (int i = 0; i < collectionPage.getGeekRatings().size(); i++) {
            assertThat(collectionPage.getGeekRatings().get(i)).isBetween(7.0, 9.0);
            Log.logInfo("Loop lap nr " + (i + 1) + ", number " + collectionPage.getGeekRatings().get(i) +
                    " is between 7.0 and 9.0");
        }
    }

    @Test
    public void filteringCollectionByWishListStatus() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.wishListPriorityFiltering();
        testHelper.setWishListOption(collectionPage.getWishListSelectedOption());
        collectionPage.acceptFilters();
        testHelper.setGamesListWithSelectedWishListOption(collectionPage.getGamesTitles());
        Log.logInfo(testHelper.getGamesListWithSelectedWishListOption().toString());
        collectionPage.openGamesFromListInNewTabs();
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 1; i < browserTabs.size(); i++) {
            driver.switchTo().window(browserTabs.get(i));
            assertThat(testHelper.getGamesListWithSelectedWishListOption().get(i - 1)).isEqualTo(gamePage.getGameTitle());
            Log.logInfo("The tab of game called: " + gamePage.getGameTitle());
            gamePage.clickInCollectionButton();
            assertThat(gamePage.getWishListSelectedOption()).isEqualTo(testHelper.getWishListOption());
            Log.logInfo(gamePage.getGameTitle() + " : wishlist option set to : " + testHelper.getWishListOption());
            driver.switchTo().window(browserTabs.get(0));
        }
    }
}
