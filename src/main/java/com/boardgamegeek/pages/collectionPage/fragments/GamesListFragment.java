package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;


public class GamesListFragment extends BasePage {

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesInCollectionList;

    @FindBy(xpath = "//th[@class='collection_title']/a")
    WebElement titleSortButton;

    @FindBy(xpath = "//th[@class='collection_bggrating']/a")
    WebElement geekRatingSortButton;

    @FindBy(xpath = "//div[@id='collection_status']")
    WebElement loadingInformation;

    @FindBy(xpath = "//span[@style='float:left;']/a[1]")
    WebElement filtersButton;

    public GamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final String gameLink = ".//div[contains(@id,'results_objectname')]/a";
    private final String gameRating = ".//td[@class='collection_bggrating']";
    private final String deleteGameButton = ".//a[contains(@onclick,'CE_DeleteItem')]";

    public GamesListFragment clickDefinedGameFromList(String name) {
        synchronization(loadingInformation);
        for (WebElement element : gamesInCollectionList) {
            if (element.findElement(By.xpath(gameLink)).getText().equals(name)) {
                click(element.findElement(By.xpath(gameLink)));
                break;
            }
        }
        synchronization2();
        return this;
    }

    public GamesListFragment openGamesFromListInNewTabs() {
        for (WebElement element : gamesInCollectionList) {
            openInNewTab(element.findElement(By.xpath(gameLink)));
        }
        return this;
    }

    public GamesListFragment chooseRandomGameFromList() {
        click(gamesInCollectionList.get(testHelper.getRandomNumber(1, gamesInCollectionList.size()))
                .findElement(By.xpath(gameLink)));
        synchronization2();
        return this;
    }

    public GamesListFragment deleteRandomGameFromList() {
        click(gamesInCollectionList.get(testHelper.getRandomNumber(1, gamesInCollectionList.size())).findElement(By.xpath(deleteGameButton)));
        driver.switchTo().alert().accept();
        return this;
    }

    public GamesListFragment sortCollectionByTitles() {
        click(titleSortButton);
        synchronization(loadingInformation);
        return this;
    }

    public GamesListFragment sortCollectionByRatings() {
        click(geekRatingSortButton);
        synchronization(loadingInformation);
        return this;
    }

    public GamesListFragment openFilters() {
        synchronization2();
        click(filtersButton);
        return this;
    }

    public List<Double> getGeekRatings() {
        return gamesInCollectionList.stream().map(e -> e.findElement(By.xpath(gameRating))
                .getText()).map(Double::parseDouble).collect(Collectors.toList());
    }

    public List<String> getGamesNames() {
        return gamesInCollectionList.stream().map(e ->
                e.findElement(By.xpath(gameLink)).getText()).collect(Collectors.toList());
    }

}


