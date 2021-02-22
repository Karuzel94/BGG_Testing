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

    public String deleteRandomGameFromList() {
        return gamesListFragment.deleteRandomGameFromList();
    }

    public CollectionPage goToFirstGameFromList() {
        gamesListFragment.goToFirstGameFromList();
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

    public int getRatingFromCollection() {
        return gamesListFragment.getRatingFromCollection();
    }

    public List<String> getGamesTitles() {
        return gamesListFragment.getGamesNames();
    }

    public List<Double> getGeekRatings() {
        return gamesListFragment.getGeekRatings();
    }

    public CollectionPage geekRatingFiltering(Double min, Double max) {
        gamesListFragment.openFilters();
        filtersFragment.geekRatingFiltering(min, max);
        return this;
    }

    public CollectionPage wishListPriorityFiltering() {
        gamesListFragment.openFilters();
        filtersFragment.chooseRandomWishListPriorityOption();
        return this;
    }

    public String getWishListSelectedOption() {
        return filtersFragment.getWishListSelectedOption();
    }

    public CollectionPage acceptFilters() {
        filtersFragment.acceptFilters();
        return this;
    }

    public CollectionPage openGamesFromListInNewTabs() {
        gamesListFragment.openGamesFromListInNewTabs();
        return this;
    }

}