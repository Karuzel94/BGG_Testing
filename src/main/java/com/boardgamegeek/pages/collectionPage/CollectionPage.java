package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;
import org.openqa.selenium.WebDriver;

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

    public String unRemovedGamesNames() {
        return gamesListFragment.unRemovedGamesNames();
    }

}




