package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;
import org.openqa.selenium.WebDriver;

public class CollectionPage extends BasePage {

    private GamesListFragment gamesListFragment;

    public CollectionPage(WebDriver driver) {
        super(driver);
    }

    public CollectionPage goToGameFromList(String name) {
        gamesListFragment.clickGameFromList(name);
        return this;
    }


}




