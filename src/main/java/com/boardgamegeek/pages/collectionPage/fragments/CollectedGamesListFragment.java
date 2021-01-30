package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CollectedGamesListFragment extends BasePage {

    public CollectedGamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
