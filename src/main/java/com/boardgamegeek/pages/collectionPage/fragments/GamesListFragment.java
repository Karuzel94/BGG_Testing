package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GamesListFragment extends BasePage {

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesInCollectionList;

    public GamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final String gameLink = ".//div[contains(@id,'results_objectname')]/a";
    private List<String> gameNames = new ArrayList<>();

    public GamesListFragment clickDefinedGameFromList(String name) {
        for (WebElement element : gamesInCollectionList) {
            if (element.findElement(By.xpath(gameLink)).getText().equals(name)) {
                click(element.findElement(By.xpath(gameLink)));
                break;
            }
        }
        return this;
    }

    public GamesListFragment chooseRandomGameFromList() {
        click(gamesInCollectionList.get(testHelper.getRandomNumber(1, gamesInCollectionList.size()))
                .findElement(By.xpath(gameLink)));
        return this;
    }

    public List<String> gamesNamesList() {
        for (WebElement element : gamesInCollectionList) {
            gameNames.add(element.findElement(By.xpath(gameLink)).getText());
        }
        return gameNames;
    }

}


