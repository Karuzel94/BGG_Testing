package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.CollectedGamesListFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CollectionPage extends BasePage {

    private CollectedGamesListFragment collectedGamesListFragment;

    public CollectionPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
        this.collectedGamesListFragment = new CollectedGamesListFragment(driver);
    }

    public CollectionPage goToGameFromList(String gameName){
        collectedGamesListFragment.clickGameFromList(gameName);
        return this;
    }



}




