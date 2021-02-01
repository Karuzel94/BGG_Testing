package com.boardgamegeek.pages.allBoardgamesPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.allBoardgamesPage.fragments.BoardGameRankFragment;
import org.openqa.selenium.WebDriver;

public class AllBoardgamesPage extends BasePage {

    private BoardGameRankFragment boardGameRankFragment;

    public AllBoardgamesPage(WebDriver driver) {
        super(driver);
        this.boardGameRankFragment = new BoardGameRankFragment(driver);
    }

    public AllBoardgamesPage chooseGame(int number){
        boardGameRankFragment.goToGame(number);
        return this;
    }


}




