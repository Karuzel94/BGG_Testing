package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilteringCollectionTest extends BaseTest {

    @Test
    public void filteringCollectionByGeekRatingTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        userMenuFragment.goToCollection();
        collectionPage.geekRatingFiltering(7, 9);
        Log.logInfo(collectionPage.getGeekRatings().toString());
        for (int i = 0; i < collectionPage.getGeekRatings().size(); i++) {
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
        collectionPage.goToGameFromList(testHelper.getGamesListWithSelectedWishlistOption()
                .get(testHelper.getRandomNumber(1, testHelper.getGamesListWithSelectedWishlistOption().size())));
        gamePage.clickInCollectionButton();
        assertThat(gamePage.getWishlistSelectedOption()).isEqualTo(testHelper.getWishlistOption());
        gamePage.clickInCollectionButton();

    }
}
