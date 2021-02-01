package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.CollectedGamesListFragment;
import org.openqa.selenium.WebDriver;

public class CollectionPage extends BasePage {

    private CollectedGamesListFragment collectedGamesListFragment;

    public CollectionPage(WebDriver driver) {
        super(driver);
        this.collectedGamesListFragment = new CollectedGamesListFragment(driver);
    }

    public CollectionPage goToGameFromList(String name) {
        collectedGamesListFragment.clickGameFromList(name);
        return this;
    }


}




