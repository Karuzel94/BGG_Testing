package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class GamesListFragment extends BasePage {

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesInCollectionList;

    @FindBy(xpath = "//th[@class='collection_title']/a")
    WebElement titleSortButton;

    @FindBy(xpath = "//th[@class='collection_bggrating']/a")
    WebElement geekRatingSortButton;

    @FindBy(xpath = "//div[@class='pace pace-active']")
    WebElement loadingProgressBar;

    @FindBy(xpath = "//div[@id='collection_status']")
    WebElement loadingInformation;

    public GamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final String gameLink = ".//div[contains(@id,'results_objectname')]/a";
    private final String gameRating = ".//td[@class='collection_bggrating']";
    private List<String> gameNames = new ArrayList<>();
    private List<String> geekRatingsList = new ArrayList<>();
    private List<Double> tempGeekRatings = new ArrayList<>();
    private List<String> tempListOfTitles = new ArrayList<>();
    private List<Double> geekRatings = new ArrayList<>();

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
        return gamesInCollectionList.stream().map(WebElement::getText).collect(Collectors.toList());

    }

    public List<String> getTempListOfTitles() {
        tempListOfTitles = gamesInCollectionList.stream().map(e ->
                e.findElement(By.xpath(gameLink)).getText()).collect(Collectors.toList());
        Collections.reverse(tempListOfTitles);
        return tempListOfTitles;
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

    public List<Double> getTempListOfRatings() {
        geekRatingsList = gamesInCollectionList.stream().map(e -> e.findElement(By.xpath(gameRating))
                .getText()).collect(Collectors.toList());
        tempGeekRatings = geekRatingsList.stream().map(s -> Double.parseDouble(s)).collect(Collectors.toList());
        Collections.sort(tempGeekRatings);
        return tempGeekRatings;
    }

    public List<Double> getOriginalListOfRatings() {
        geekRatingsList = gamesInCollectionList.stream().map(e -> e.findElement(By.xpath(gameRating))
                .getText()).collect(Collectors.toList());
        geekRatings = geekRatingsList.stream().map(s -> Double.parseDouble(s)).collect(Collectors.toList());
        return geekRatings;

    }

    public List<String> getListOfGamesNames() {
        gameNames = gamesInCollectionList.stream().map(e ->
                e.findElement(By.xpath(gameLink)).getText()).collect(Collectors.toList());
        return gameNames;
    }

}


