package com.boardgamegeek.pages.allBoardgamesPage.fragments;

import com.boardgamegeek.pages.allBoardgamesPage.AllBoardgamesPage;
import com.boardgamegeek.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoardGameRankFragment extends AllBoardgamesPage {

    public BoardGameRankFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@id,'results_objectname')]/a")
    List<WebElement> gamesOnList;

    public BoardGameRankFragment goToGame(int number){
        Log.logInfo("Game index is: "+ (number + 1));
        click(gamesOnList.get(number));
        return this;
    }
}
