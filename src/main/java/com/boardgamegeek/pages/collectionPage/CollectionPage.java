package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.FiltersFragment;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CollectionPage extends BasePage {

    private final GamesListFragment gamesListFragment;
    private final FiltersFragment filtersFragment;

    public CollectionPage(WebDriver driver) {
        super(driver);
        this.gamesListFragment = new GamesListFragment(driver);
        this.filtersFragment = new FiltersFragment(driver);
    }

    public CollectionPage goToGameFromList(String name) {
        gamesListFragment.clickDefinedGameFromList(name);
        return this;
    }

    public CollectionPage chooseRandomGameFromList() {
        gamesListFragment.chooseRandomGameFromList();
        return this;
    }

    public CollectionPage sortCollectionByTitles() {
        gamesListFragment.sortCollectionByTitles();
        return this;
    }

    public CollectionPage sortCollectionByRatings() {
        gamesListFragment.sortCollectionByRatings();
        return this;
    }

    public List<String> getGamesTitles() {
        return gamesListFragment.getGamesNames();
    }

    public List<String> getGeekRatings() {
        return gamesListFragment.getGeekRatings();
    }

    public CollectionPage geekRatingFiltering(int min, int max) {
        gamesListFragment.openFilters();
        filtersFragment.geekRatingFiltering(min, max);
        return this;
    }

    public CollectionPage wishlistPriorityFiltering() {
        gamesListFragment.openFilters();
        filtersFragment.chooseRandomWishlistPriorityOption();
        return this;
    }

    public String getWishlistSelectedOption() {
        return filtersFragment.getWishlistSelectedOption();
    }

    public CollectionPage acceptFilters() {
        filtersFragment.acceptFilters();
        return this;
    }
}