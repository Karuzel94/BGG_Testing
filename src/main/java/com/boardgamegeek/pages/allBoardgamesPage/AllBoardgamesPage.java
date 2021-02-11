package com.boardgamegeek.pages.allBoardgamesPage;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllBoardgamesPage extends BasePage {

    public AllBoardgamesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesOnList;

    public AllBoardgamesPage goToRandomGame() {
        click(gamesOnList.get(testHelper.getRandomNumber(1, gamesOnList.size()))
                .findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a")));
        return this;
    }
}




