package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CollectedGamesListFragment extends BasePage {

    public CollectedGamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[contains(@id,'results_objectname')]/a")
    List<WebElement> gamesInCollectionList;


    public CollectedGamesListFragment clickGameFromList(String name) {
        clickElementFromList(gamesInCollectionList, name);
        return this;
    }

}
