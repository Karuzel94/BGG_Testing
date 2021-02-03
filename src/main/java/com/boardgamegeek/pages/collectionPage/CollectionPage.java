package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;
import org.openqa.selenium.WebDriver;

public class CollectionPage extends BasePage {

    private GamesListFragment gamesListFragment;

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

    public CollectionPage checkIfTheGameHasBeenDeleted(String gameName) {
        gamesListFragment.checkIfTheGameHasBeenDeleted(gameName);
        return this;
    }

}




