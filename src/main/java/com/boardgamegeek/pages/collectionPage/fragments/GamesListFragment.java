package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.utilities.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GamesListFragment extends BasePage {

    public TestHelper testHelper;

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesInCollectionList;

    public GamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        testHelper = new TestHelper();
    }

    public GamesListFragment clickDefinedGameFromList(String name) {
        for (WebElement element : gamesInCollectionList) {
            if (element.findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a")).getText().equals(name)) {
                click(element.findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a")));
                break;
            }
        }
        return this;
    }

    public GamesListFragment chooseRandomGameFromList() {
        click(gamesInCollectionList.get(testHelper.getRandomNumber(1, gamesInCollectionList.size()))
                .findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a")));
        return this;
    }

    public String unRemovedGamesNames() {
        String names = "";
        for (WebElement element : gamesInCollectionList) {
            names += " " + element.findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a"))
                    .getText();
        }
        return names;
    }

}


