package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamePropertiesFragment extends BasePage {

    public GamePropertiesFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='game-header-primary-actions hidden-game-header-collapsed']/span[3]/ng-include/div/div[2]/span/span[2]/span/span/span/button/i")
    WebElement addToCollectionButton;

    @FindBy(xpath = "//div[@class='game-header']/div[2]/div[1]/div[1]/div[2]/h1[1]/a[1]")
    WebElement gameTitle;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveCollectingButton;

    public String getGameTitle() {
        return gameTitle.getText();
    }

    public GamePropertiesFragment addGameToCollection() {
        click(addToCollectionButton);
        click(saveCollectingButton);
        return this;
    }
}
