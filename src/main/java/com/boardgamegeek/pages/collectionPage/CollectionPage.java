package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CollectionPage extends BasePage {

    private final GamesListFragment gamesListFragment;

    public CollectionPage(WebDriver driver) {
        super(driver);
        this.gamesListFragment = new GamesListFragment(driver);
    }

    public CollectionPage goToGameFromList(String name) {
        gamesListFragment.clickDefinedGameFromList(name);
        return this;
    }

    public CollectionPage chooseRandomGameFromList() {
        gamesListFragment.chooseRandomGameFromList();
        return this;
    }

    public List<String> gamesNamesList() {
        return gamesListFragment.gamesNamesList();
    }

    public List<String> getTempListOfTitles() {
        return gamesListFragment.getTempListOfTitles();
    }

    public CollectionPage sortCollectionByTitles() {
        gamesListFragment.sortCollectionByTitles();
        return this;
    }

    public CollectionPage sortCollectionByRatings() {
        gamesListFragment.sortCollectionByRatings();
        return this;
    }

    public List<String> getSortedListWithGameTitles() {
        return gamesListFragment.getListOfGamesNames();
    }

    public List<Double> getTempListOfRatings() { return gamesListFragment.getTempListOfRatings(); }

    public List<Double> getSortedListWithGameRatings() {return gamesListFragment.getOriginalListOfRatings(); }

}




