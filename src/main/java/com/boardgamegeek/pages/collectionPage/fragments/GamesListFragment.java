package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GamesListFragment extends BasePage {

    public GamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private WebElement gameLink;

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesInCollectionList;

    public GamesListFragment clickDefinedGameFromList(String name) {
        for (WebElement element : gamesInCollectionList) {
            gameLink = element.findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a"));
            if (gameLink.getText().equals(name)) {
                click(gameLink);
                break;
            }
        }
        return this;
    }

    public GamesListFragment chooseRandomGameFromList() {
        Random randomizer = new Random();
        int number = randomizer.nextInt(gamesInCollectionList.size());
        click(gamesInCollectionList.get(number)
                .findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a")));
        return this;
    }

    public GamesListFragment checkIfTheGameHasBeenDeleted(String gameName) {
        for (WebElement element : gamesInCollectionList) {
            assertThat(element.findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a"))
                    .getText()).isNotEqualTo(gameName);
        }
        Log.logInfo("Game: " + gameName + " was successfully deleted from Collection");
        return this;
    }


}


