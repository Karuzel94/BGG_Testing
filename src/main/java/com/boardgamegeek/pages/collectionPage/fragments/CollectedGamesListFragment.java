package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.collectionPage.CollectionPage;
import com.boardgamegeek.pages.gamePage.GamePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectedGamesListFragment extends CollectionPage {

    public CollectedGamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }






}
