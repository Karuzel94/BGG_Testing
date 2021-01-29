package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.collectionPage.fragments.CollectedGamesListFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionPage extends BasePage {

    private CollectedGamesListFragment collectedGamesListFragment;

    public CollectionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.collectedGamesListFragment = new CollectedGamesListFragment(driver);
    }

    /*String gra;
    @FindBy(xpath = "//a[text()='Gloomhaven']")
            WebElement selectedGame;*/

}




