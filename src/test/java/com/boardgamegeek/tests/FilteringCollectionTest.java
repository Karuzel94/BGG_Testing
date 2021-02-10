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
        collectionPage.geekRatingFiltering("7.000", "9.000");
        collectionPage.acceptFilters();
        Log.logInfo("How many records after filtering? " + collectionPage.getGeekRatings().size());
        for (int i = 0; i < collectionPage.getGeekRatings().size(); i++) {
            Log.logInfo("Loop lap nr " + (i + 1));
            assertThat(collectionPage.getGeekRatings().get(i)).isBetween("7.000", "9.000");
        }
    }

    @Test
    public void filteringCollectionByWishlistStatus() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.wishlistPriorityFiltering();
        testHelper.setWishlistOption(collectionPage.getWishlistSelectedOption());
        collectionPage.acceptFilters();
        testHelper.setGamesListWithSelectedWishListOption(collectionPage.getGamesTitles());
        Log.logInfo(testHelper.getGamesListWithSelectedWishlistOption().toString());
        collectionPage.openGamesFromListInNewTabs();
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 1; i < browserTabs.size(); i++) {
            driver.switchTo().window(browserTabs.get(i));
            gamePage.clickInCollectionButton();
            assertThat(gamePage.getWishlistSelectedOption()).isEqualTo(testHelper.getWishlistOption());
            Log.logInfo(gamePage.getGameTitle() + " : wishlist option set to : " + testHelper.getWishlistOption());
            driver.switchTo().window(browserTabs.get(0));
        }
    }
}
